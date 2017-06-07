package com.san.graduation.controller.param;

import com.san.graduation.common.BaseParam;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by huangdongliang on 2017/5/6.
 */

public class UserParam extends BaseParam {
    //private String userNo; // 用户编号
    @NotNull
    @Length(min = 8,max = 30)
    private String password;// 密码
    @NotNull
    @Pattern(regexp = "1[0-9]{10,10}")
    private String mobileNo;// 手机号码
    @NotNull
    private String province;// 省
    @NotNull
    private String city;// 市
    @NotNull
    private String address;// 详细地址
    @NotNull
    private String school;// 学习
    @NotNull
    private String major;// 专业
    @NotNull
    private String userName;// 用户名

   /* public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
