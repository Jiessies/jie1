package com.demo1.mutisourceweb.service.impl;

import com.demo1.mutisourceweb.domain.User;
import com.demo1.mutisourceweb.mapper.MutiSourceMapper;
import com.demo1.mutisourceweb.service.MutiSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutiSourceServiceImpl implements MutiSourceService {

    @Autowired
    private MutiSourceMapper mutiSourceMapper;

    @Override
    public Object addUser(User user) {
        return mutiSourceMapper.insertSelective(user);
    }

    @Override
    public Object selectAllUser() {
        return mutiSourceMapper.selectAllUser();
    }
}
