package com.san.graduation.dto;

import com.san.graduation.common.BaseBean;

/**
 * Created by huangdongliang on 2017/5/6.
 *
 * 返回参数数据，继承BaseBean
 */

public class UserDto extends BaseBean {
    private String userNo;
    private String mobileNo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
