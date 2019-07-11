package com.demo1.mutisourceweb.service;

import com.demo1.mutisourceweb.domain.User;

public interface MutiSourceService {
    Object addUser(User user);

    Object selectAllUser();
}
