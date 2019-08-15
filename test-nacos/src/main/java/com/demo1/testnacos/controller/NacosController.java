package com.demo1.testnacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/nac")
public class NacosController {

    @NacosValue(value = "${nacos.test.propertie:123}", autoRefreshed = true)
    private String testProperties;

    @GetMapping("/test")
    public String test() {
        return testProperties;
    }
}
