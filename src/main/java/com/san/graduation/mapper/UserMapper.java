package com.san.graduation.mapper;

import com.san.graduation.common.mybatis.CommonMapper;
import com.san.graduation.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huangdongliang on 2017/5/6.
 *
 * 数据库操作类，都是继承CommonMaper
 * 对应写map.xml 文件
 *
 *
 */
public interface UserMapper extends CommonMapper<User>{

    public void updateByUserNo(User user);

    public void deleteByUserNo(String userNo);

    public User findByUserNo(String userNo);

    public User findByMobileNoAndPassword(@Param("mobileNo") String mobile, @Param("password")String password);

}
