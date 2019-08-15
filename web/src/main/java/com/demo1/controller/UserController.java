package com.demo1.controller;

import com.demo1.domain.User;
import com.demo1.service.UserService;
import com.demo1.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public R<Integer> addUser(User user) {
        user = new User();
        user.setPhone("133443545");
        user.setPassword("123443");
        user.setUserName("用户名");
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }
}
