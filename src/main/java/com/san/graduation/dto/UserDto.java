package com.san.graduation.dto;

import com.san.graduation.common.BaseBean;

/**
 * Created by huangdongliang on 2017/5/6.
 *
 * 返回参数数据，继承BaseBean
 */

public class UserDto extends BaseBean {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
