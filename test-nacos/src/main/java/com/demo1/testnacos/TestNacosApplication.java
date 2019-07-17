package com.demo1.testnacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@NacosPropertySource(dataId = "springboot2-nacos-config", autoRefreshed = true)
@SpringBootApplication
public class TestNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestNacosApplication.class, args);
    }

}
