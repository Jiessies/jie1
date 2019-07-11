package com.demo1.dubboservice.controller;

import com.demo1.dubbofacade.domain.DubboUser;
import com.demo1.dubbofacade.service.DubooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/testdubbo")
public class DubboServiceController {

    @Autowired
    private DubooService dubooService;

    @GetMapping(value = "/getuser")
    public List<DubboUser> getAllUser(){
        return dubooService.findAllUser();
    }
}
