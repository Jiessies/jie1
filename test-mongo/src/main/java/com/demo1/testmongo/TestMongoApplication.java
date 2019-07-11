package com.demo1.testmongo;

import com.demo1.testmongo.domain.Customer;
import com.demo1.testmongo.repository.CustomerRepository;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestMongoApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(TestMongoApplication.class);

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TestMongoApplication.class, args);
    }

    @Override
    public void run(String... args){
        // 删除全部
//        repository.deleteAll();
        // 添加一条数据
//        repository.save(new Customer("于", "起宇"));
//        Gson gson = new Gson();
        // 查询全部
//        logger.info(gson.toJson(repository.findAll()));

        logger.info("【【【【【SpringBoot整合Mongodb启动完成.】】】】】");
    }
}
