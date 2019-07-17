package com.demo1.testhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class TestHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestHystrixApplication.class, args);
    }

}
