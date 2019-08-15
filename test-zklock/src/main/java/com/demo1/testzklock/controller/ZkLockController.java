package com.demo1.testzklock.controller;

import com.demo1.testzklock.service.ZkLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zk")
public class ZkLockController {

    @Autowired
    private ZkLockService zkLockService;

    @RequestMapping(value = "/lock")
    public String zkLocktest() {
        try {
            zkLockService.acquireLockTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

}
