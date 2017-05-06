package com.san.graduation.service;

import com.san.graduation.domain.User;

/**
 * Created by shanlin on 2017/5/6.
 * 服务类接口定义
 *
 */
public interface UserService {

    public void insert(User user);

    public void updateByUserNo(User user);

    public void deleteByUserNo(String userNo);

    public User findByUserNo(String userNo);

    public User findByMobileNoAndPassword(String mobile,String password);

}
