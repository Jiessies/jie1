package com.demo1.mutisourceweb.controller;

import com.demo1.mutisourceweb.config.aop.DataSourceTypeAnnotation;
import com.demo1.mutisourceweb.domain.User;
import com.demo1.mutisourceweb.service.MutiSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/muti")
public class MutiSourceController {

    @Autowired
    private MutiSourceService mutiSourceService;

    @DataSourceTypeAnnotation(value = "WRITE")
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public Object addUser(User user){
        user= new User();
        user.setPhone("133443545");
        user.setPassword("123443");
        user.setUserName("用户名");
        return mutiSourceService.addUser(user);
    }

    @DataSourceTypeAnnotation(value = "READ")
    @GetMapping("/all")
    public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        return mutiSourceService.selectAllUser();
    }
}
