package com.demo1.dubboservice.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo1.dubbofacade.domain.DubboUser;
import com.demo1.dubbofacade.service.DubooService;
import com.demo1.dubboservice.mapper.DubooMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = DubooService.class, version = "1.0.0", timeout = 20000, retries = 0)
public class DubooServiceImpl implements DubooService {

    @Autowired
    private DubooMapper dubooMapper;

    @Override
    public String getName(String name) {
        return "zhangjie";
    }

    @Override
    public List<DubboUser> findAllUser() {
        return dubooMapper.findAllUser();
    }
}
