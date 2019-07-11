package com.demo1.testes.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 8152048348166952579L;
    protected Long id;
}
