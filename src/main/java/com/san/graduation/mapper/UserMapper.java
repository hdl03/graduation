package com.san.graduation.mapper;

import com.san.graduation.common.mybatis.CommonMapper;
import com.san.graduation.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * 用户表mappper
 */

public interface UserMapper extends CommonMapper<User> {

    public int deleteByUserNo(String userNo);

    public User findByUserNo(String userNo);

    public User findByMobileNo(String mobileNo);

    public User findByMobileNoAndPassword(@Param("mobileNo") String mobile, @Param("password")String password);

    public int updateUserInfoByUserNo(User user);
}