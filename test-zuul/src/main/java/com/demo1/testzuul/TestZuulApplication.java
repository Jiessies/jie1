package com.demo1.testzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class TestZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestZuulApplication.class, args);
    }

}
