package com.san.graduation.controller.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.error.Error;
import com.san.graduation.dto.UserInfoDto;

/**
 * Created by wuzr on 2017/5/29.
 * 返回用户详细信息结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoResult extends BaseResponse {
    private UserInfoDto data;

    public UserInfoDto getData() {
        return data;
    }

    public void setData(UserInfoDto data) {
        this.data = data;
    }

    public static UserInfoResult succcess() {
        UserInfoResult userResult = new UserInfoResult();
        userResult.setCode(Error.SUCCESS.getCode());
        userResult.setMessage(Error.SUCCESS.getMessage());
        return userResult;
    }
}
