package com.san.graduation.domain;

import com.san.graduation.common.BaseEntity;

import javax.persistence.Table;

/**
 * Created by huangdongliang on 2017/5/6.
 *
 * 数据库实体，都需要继承BaseEntity
 *
 */
@Table(name = "user")
public class User extends BaseEntity{
    private String userNo; // 用户编号
    private String password;// 密码
    private String mobileNo;// 手机号码
    private String province;// 省
    private String city;// 市
    private String address;// 详细地址
    private String school;// 学习
    private String major;// 专业
    private String userName;// 用户名

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

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
