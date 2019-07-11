package com.demo1.testmongo.service;

import com.demo1.testmongo.domain.Authority;

import java.util.List;

public interface AuthorityService {
    public List<Authority> findAll(int page, int limit);
    public List<Authority> findAll();
    public long count();
    public void save(Authority authority);
    public void delete(String id);
    public Authority find(String id);
}
