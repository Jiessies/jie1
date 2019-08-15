package com.demo1.testhystrix.controller;

import com.demo1.testhystrix.service.HystrixService;
import com.demo1.testhystrix.service.SemaphoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hys")
public class TestHystrixController {

    @Autowired
    private HystrixService hystrixService;

    @Autowired
    private SemaphoreService semaphoreService;

    @RequestMapping(value = "/test")
    public String testHys(@RequestParam(value = "name") String name) {
        String response = hystrixService.testHys(name);
        return response;
    }

    @RequestMapping(value = "/semap")
    public String hi(@RequestParam(value = "name") String name) {
        String response = semaphoreService.hi(name);
        return response;
    }
}
