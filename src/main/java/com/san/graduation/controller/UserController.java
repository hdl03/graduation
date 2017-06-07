package com.san.graduation.controller;

import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.UserContext;
import com.san.graduation.common.error.Error;
import com.san.graduation.common.util.Logger;
import com.san.graduation.controller.param.GetUserInfoParam;
import com.san.graduation.controller.param.UpdateUserParam;
import com.san.graduation.controller.param.UserParam;
import com.san.graduation.controller.result.UserInfoResult;
import com.san.graduation.controller.result.UserResult;
import com.san.graduation.domain.User;
import com.san.graduation.dto.UserDto;
import com.san.graduation.dto.UserInfoDto;
import com.san.graduation.service.impl.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by huangdongliang on 2017/5/6.
 * Controller 提供接口，对外暴露接口
 * 交互数据格式是json
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册接口
     *
     * @param userParam
     * @return
     */
    @RequestMapping(value = "register/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    // 增加参数校验
    public BaseResponse registerUser(@RequestBody @Valid UserParam userParam) {
        Logger.info(this, "init register : ");
        User user = new User();
        BeanUtils.copyProperties(userParam, user, "userNo");
        userService.insert(user);
        UserResult userResult = UserResult.succcess();
        return userResult;
    }

    /**
     * 用户登录接口
     *
     * @param userParam
     * @return
     */

    @RequestMapping(value = "login/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse loginUser(@RequestBody UserParam userParam) {
        Logger.info(this, "init loginUser : ");
        // 手机和密码不能为空
        if (null == userParam || StringUtils.isNotBlank(userParam.getMobileNo()) || StringUtils.isNotBlank(userParam.getPassword())) {
            Logger.info(this, "param is null");
            return BaseResponse.fail(Error.PARAMS_ERROR.getCode(), Error.PARAMS_ERROR.getMessage());
        }
        UserDto userDto = userService.findByMobileNoAndPassword(userParam.getMobileNo(), userParam.getPassword());
        UserResult userResult = UserResult.succcess();
        userResult.setUserDto(userDto);
        return userResult;
    }

    /**
     * 更新用户信息
     */
    @RequestMapping(value = "update/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse updateUserInfo(@RequestBody UpdateUserParam updateUserParam) {
        Logger.info(this, "init updateUserInfo : ");
        updateUserParam.setUserNo(UserContext.getCurrentUserNo().get());
        userService.updateUserInfoByUserNo(updateUserParam);
        UserResult userResult = UserResult.succcess();
        return userResult;
    }

    /**
     * 获取用户详细信息
     */
    @RequestMapping(value = "find/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse updateUserInfo(@RequestBody GetUserInfoParam param) {
        Logger.info(this, "init getUserInfo : ");
        UserInfoDto dto = userService.getUserInfoByUserNo(param.getUserNo());
        UserInfoResult result = UserInfoResult.succcess();
        result.setData(dto);
        return result;
    }
}
