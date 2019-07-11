package com.demo1.testes.service.impl;

import com.demo1.testes.mapper.UserMapper;
import com.demo1.testes.mode.User;
import com.demo1.testes.service.TestHikariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestHikariServiceImpl implements TestHikariService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }
}
