package com.san.graduation.filter;

import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.UserContext;
import com.san.graduation.common.constants.Constant;
import com.san.graduation.common.error.Error;
import com.san.graduation.common.util.DateUtil;
import com.san.graduation.common.util.JsonBinderUtil;
import com.san.graduation.common.util.Logger;
import com.san.graduation.common.util.MatchUrlUtils;
import com.san.graduation.domain.User;
import com.san.graduation.domain.UserToken;
import com.san.graduation.mapper.UserMapper;
import com.san.graduation.mapper.UserTokenMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.Span;
import org.springframework.http.MediaType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by shanlin on 2017/4/6.
 * <p>
 * 判断 session
 * <p>
 * 首先判断这个接口需不要session
 * <p>
 * 不需要直接到过滤
 * <p>
 * 需要的，要做过滤，判断session是否过期
 */
@WebFilter(urlPatterns = "/*")
public class BasicTokenFilter implements Filter {

    @Value("${graduation.login.expireTime}")
    private Long expireTime;
    @Autowired
    private MatchUrlUtils matchUrlUtils;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTokenMapper userTokenMapper;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        long curTime = System.currentTimeMillis();
        String url = httpServletRequest.getServletPath();
        Logger.debug(this, "  url is " + url);
        String method = httpServletRequest.getMethod();

        Object object = MDC.get(Span.TRACE_ID_NAME);
        String traceId = (object == null ? "" : object.toString());
//        Cookie cookie = new Cookie(Constant.TRACEID,tranceId);
//        httpServletResponse.addCookie(cookie);
        httpServletResponse.setHeader(Constant.TRACEID,traceId);
        try {
            if (!Constant.OPTIONS_METHOD.equals(method)) {
                // 匹配到，需要带token 的url
                if (matchUrlUtils.checkUrls(url)) {
                    if(!doCheckToken(httpServletRequest, httpServletResponse, curTime, false)){
                        // 返回值为false ,说明直接返回，不需要再走过滤器
                        return;
                    }
                } else {
                    // 没有带token，可以正常访问,带了token ，需要保存用户数据
                    if(!doCheckToken(httpServletRequest, httpServletResponse, curTime, true)){
                        // 返回值为false ,说明直接返回，不需要再走过滤器
                        return;
                    }
                }
            }
            chain.doFilter(httpServletRequest, httpServletResponse);
        } finally {
            UserContext.clean();
        }
        return;

    }

    @Override
    public void destroy() {
        Logger.info(this, "destroy BasicTokenFilter ");
    }


    public boolean doCheckToken(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, long curTime, boolean flag)
            throws IOException {

        // 获取请求头的token信息
        String token = httpServletRequest.getHeader(Constant.TOKEN);
        Logger.info(this, "toke is " + token + " , flag is " + flag);
        // 没有带token　
        if (StringUtils.isBlank(token) && flag) {
            return true;
        }
        try {
            // 数据库查询
            UserToken userToken = userTokenMapper.findByToken(token);
            if (StringUtils.isBlank(token) || null == userToken) {
                Logger.warn(this, "token 不存在:");
                BaseResponse baseResponse = BaseResponse.fail(Error.NOT_EXIST_TOKEN.getCode(), Error.NOT_EXIST_TOKEN.getMessage());
                this.setResponseData(httpServletResponse, JsonBinderUtil.toJson(baseResponse));
                return false;
            }
            // 防止并发
            readWriteLock.writeLock().lock();

            Logger.debug(this, "token is not null");

            if (curTime > userToken.getExpireTime()) {
                // 报token 失效
                Logger.info(this, "curTime is " + curTime + " expireTime is " + userToken.getExpireTime());
                BaseResponse baseResponse = BaseResponse.fail(Error.OUT_TIME_TOKEN.getCode(), Error.OUT_TIME_TOKEN.getMessage());
                this.setResponseData(httpServletResponse, JsonBinderUtil.toJson(baseResponse));
                return false;
            } else {

                // 否则，更新时间
                userToken.setLastTime(DateUtil.getDate());
                userToken.setExpireTime(System.currentTimeMillis() + expireTime);
                userTokenMapper.updateByPrimaryKey(userToken);

                // 设置一个本地线程，保存用户信息
                User user = userMapper.findByUserNo(userToken.getUserNo());
                //
                if (null != user) {
                    UserContext.init(user.getUserNo(),
                            user.getMobileNo());
                } else {
                    // 用户不存在
                    Logger.info(this, "用户不存在");
                    BaseResponse baseResponse = BaseResponse.fail(Error.NOT_EXIST_USER.getCode(), Error.NOT_EXIST_USER.getMessage());
                    this.setResponseData(httpServletResponse, JsonBinderUtil.toJson(baseResponse));
                    return false;
                }
            }


        } finally {
            // 解锁
            if (readWriteLock.isWriteLocked()) {
                readWriteLock.writeLock().unlock();
            }
        }
        return true;
    }

    /**
     * 设置结果值
     *
     * @param httpServletResponse
     * @param result
     * @throws IOException
     */
    public void setResponseData(HttpServletResponse httpServletResponse, String result) throws IOException {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = httpServletResponse.getWriter();
        out.print(result);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

}
