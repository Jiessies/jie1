package com.demo1.demoweb.controller;

import com.demo1.dubbofacade.domain.DubboUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/demo-web")
public class DubboController {

    @GetMapping(value = "/getName")
    public String getName(@RequestParam String name) {
        DubboUser dubboUser = new DubboUser();
        dubboUser.setUserName(name);
        return name;
    }

}
