package com.san.graduation.mapper;

import com.san.graduation.common.mybatis.CommonMapper;
import com.san.graduation.domain.UserToken;
import tk.mybatis.mapper.common.Mapper;

import java.util.Optional;

/**
 *
 * token 表
 */
public interface UserTokenMapper extends CommonMapper<UserToken> {

    public UserToken findByUserNo(String userNo);

    public UserToken findByToken(String token);

}