package com.demo1.testmongo.domain;

import lombok.Data;

import java.util.List;

@Data
public class AuthorityVO {
    private int code;
    private String msg;
    private long count;
    private List<Authority> data;
}
