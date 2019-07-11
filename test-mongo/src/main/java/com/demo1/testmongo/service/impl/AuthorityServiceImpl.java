package com.demo1.testmongo.service.impl;

import com.demo1.testmongo.domain.Authority;
import com.demo1.testmongo.repository.AuthorityRepository;
import com.demo1.testmongo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public List<Authority> findAll(int page,int limit) {
        Pageable pageable = new PageRequest(page-1,limit);
        PageImpl<Authority> authorityPage = authorityRepository.findAll(pageable);
        return authorityPage.getContent();
    }

    @Override
    public long count() {
        return authorityRepository.count();
    }

    @Override
    public void save(Authority authority) {
        authorityRepository.save(authority);
    }

    @Override
    public void delete(String id) {
        authorityRepository.deleteById(id);
    }

    @Override
    public Authority find(String id) {
        return authorityRepository.getById(id);
    }
}
