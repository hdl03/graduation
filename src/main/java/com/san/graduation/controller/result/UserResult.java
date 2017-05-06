package com.san.graduation.controller.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.san.graduation.common.BaseBean;
import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.error.Error;
import com.san.graduation.dto.UserDto;

/**
 * Created by huangdongliang on 2017/5/6.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResult extends BaseResponse {
    private UserDto userDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }


    public static UserResult succcess() {
        UserResult userResult = new UserResult();
        userResult.setCode(Error.SUCCESS.getCode());
        userResult.setMessage(Error.SUCCESS.getMessage());
        return userResult;
    }

}



