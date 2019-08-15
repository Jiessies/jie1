package com.demo1.testes.service.impl;

import com.demo1.testes.domain.Country;
import com.demo1.testes.repository.CountrySearchRepository;
import com.demo1.testes.service.CountrySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CountrySearchServiceImpl implements CountrySearchService {

    @Autowired
    private CountrySearchRepository countrySearchRepository;


    @Override
    public Page<Country> getCountryByName(String name) {
        Page<Country> countrys = countrySearchRepository.findCountryByName("测试", PageRequest.of(0, 10));
        return countrys;
    }
}
