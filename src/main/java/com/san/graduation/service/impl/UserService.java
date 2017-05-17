package com.san.graduation.service.impl;

import com.san.graduation.common.util.DateUtil;
import com.san.graduation.common.util.Logger;
import com.san.graduation.common.util.UUIDUtils;
import com.san.graduation.domain.User;
import com.san.graduation.domain.UserToken;
import com.san.graduation.dto.UserDto;
import com.san.graduation.exception.ExistUserException;
import com.san.graduation.exception.WrangUserOrPassException;
import com.san.graduation.mapper.UserMapper;
import com.san.graduation.mapper.UserTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by huangdongliang on 2017/5/6.
 * 接口实现类
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTokenMapper userTokenMapper;
    @Value("${graduation.login.expireTime}")
    private Long expireTime;

    public int insert(User user) {
        // 判断是否是否注册
        // 用户编号，手动设置使用UUID
        User userMap = userMapper.findByMobileNo(user.getMobileNo());
        if (null == userMap) {
            //用户已经存在
            Logger.error(this, "用户已经存在");
            throw new ExistUserException(user.getMobileNo());
        }
        user.setUserNo(UUIDUtils.getInstance().getUniqueId());
        return userMapper.insert(user);
    }

    public int updateByUserNo(User user) {
        return userMapper.updateByPrimaryKey(user);

    }

    public int deleteByUserNo(String userNo) {
        return userMapper.deleteByUserNo(userNo);
    }


    public User findByUserNo(String userNo) {
        User user = userMapper.findByUserNo(userNo);
        Logger.info(this, "findByUserNo " + user);
        return user;


    }

    public User findByMobileNo(String mobileNo) {
        User user = userMapper.findByMobileNo(mobileNo);
        Logger.info(this, "findByMobileNo " + user);
        return user;
    }


    public UserDto findByMobileNoAndPassword(String mobile, String password) {
        User user = userMapper.findByMobileNoAndPassword(mobile, password);
        Logger.info(this, "findByMobileNo " + user);
        if (null == user) {
            // 记入不存在抛出错误的用户名或密码
            Logger.info(this,"not exist user");
            throw new WrangUserOrPassException();
        }
        UserToken userToken = userTokenMapper.findByUserNo(user.getUserNo());
        // 查询到token 更新token，否则创建token
        String token = UUIDUtils.getInstance().getUniqueId();
        if (null != userToken) {            ;
            userToken.setToken(token);
            userToken.setExpireTime(System.currentTimeMillis() + expireTime);
            userTokenMapper.updateByPrimaryKey(userToken);
        } else {
            userToken = new UserToken();
            userToken.setToken(token);
            userToken.setExpireTime(System.currentTimeMillis() + expireTime);
            userToken.setLastTime(DateUtil.getDate());
            userToken.setUserNo(user.getUserNo());
            userTokenMapper.updateByPrimaryKey(userToken);
        }

        // 返回token信息
        UserDto userDto = new UserDto();
        userDto.setToken(token);
        return userDto;


    }
}
