package com.san.graduation.domain;

import com.san.graduation.common.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_token")
public class UserToken extends BaseEntity {
    @Column(name = "expire_time")
    private Long expireTime;

    @Column(name = "last_time")
    private Date lastTime;

    private String token;

    @Column(name = "user_no")
    private String userNo;

    /**
     * @return expire_time
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * @return last_time
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * @param lastTime
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * @param userNo
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}