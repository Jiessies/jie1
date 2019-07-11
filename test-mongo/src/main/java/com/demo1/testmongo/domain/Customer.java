package com.demo1.testmongo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {

    @Id
    public String id;
    /**
     * 客户名称
     */
    public String firstName;
    /**
     * 客户姓氏
     */
    public String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
