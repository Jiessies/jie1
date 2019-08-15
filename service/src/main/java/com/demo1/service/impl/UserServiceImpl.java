package com.demo1.service.impl;

import com.demo1.dao.UserMapper;
import com.demo1.domain.User;
import com.demo1.service.UserService;
import com.demo1.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public R<Integer> addUser(User user) {
        R<Integer> result = new R<Integer>();
        Integer insertNum = userMapper.insertSelective(user);
        if (insertNum > 0) {
            result.setStatus(0);
        } else {
            result.setStatus(1);
        }
        result.setData(insertNum);
        return result;
    }

    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> user = userMapper.selectAllUser();
        PageInfo result = new PageInfo(user);
        return result;
    }
}
