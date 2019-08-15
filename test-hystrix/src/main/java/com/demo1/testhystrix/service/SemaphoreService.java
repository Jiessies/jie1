package com.demo1.testhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class SemaphoreService {

    @HystrixCommand(fallbackMethod = "hiFail", ignoreExceptions = ArithmeticException.class, commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "9"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "20"),
            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
    })
    public String hi(String name) {
        try {
//            int i= 1/0;
            Thread.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hi " + name;
    }


    public String hiFail(String name, Throwable e) {
        if (e != null) {
            e.printStackTrace();
        }
        return "hiFail " + name;
    }
}
