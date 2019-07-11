package com.demo1.dubbofacade.service;

import com.demo1.dubbofacade.domain.DubboUser;

import java.util.List;

public interface DubooService {
    public String getName(String name);
    public List<DubboUser> findAllUser();
}
