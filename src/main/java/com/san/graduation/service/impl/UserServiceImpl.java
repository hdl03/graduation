package com.san.graduation.service.impl;

import com.san.graduation.domain.User;
import com.san.graduation.mapper.UserMapper;
import com.san.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huangdongliang on 2017/5/6.
 * 接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateByUserNo(User user) {
        userMapper.updateByUserNo(user);

    }

    @Override
    public void deleteByUserNo(String userNo) {
            userMapper.deleteByUserNo(userNo);
    }

    @Override
    public User findByUserNo(String userNo) {
        return userMapper.findByUserNo(userNo);
    }

    @Override
    public User findByMobileNoAndPassword(String mobile, String password) {
        return userMapper.findByMobileNoAndPassword(mobile,password);
    }
}
