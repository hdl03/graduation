package com.san.graduation.controller;

import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.util.Logger;
import com.san.graduation.controller.param.UserParam;
import com.san.graduation.controller.result.UserResult;
import com.san.graduation.domain.User;
import com.san.graduation.dto.UserDto;
import com.san.graduation.service.impl.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public BaseResponse registerUser(@RequestBody UserParam userParam) {
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
        UserDto userDto = userService.findByMobileNoAndPassword(userParam.getMobileNo(), userParam.getPassword());
        UserResult userResult = UserResult.succcess();
        userResult.setUserDto(userDto);
        return userResult;
    }

}
