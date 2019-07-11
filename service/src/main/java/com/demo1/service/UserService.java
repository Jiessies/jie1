package com.demo1.service;

import com.demo1.domain.User;
import com.demo1.utils.R;
import com.github.pagehelper.PageInfo;

public interface UserService {
    R<Integer> addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
