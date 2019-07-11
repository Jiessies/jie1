package com.demo1.testes.service;

import com.demo1.testes.domain.Country;
import org.springframework.data.domain.Page;

public interface CountrySearchService {
    Page<Country> getCountryByName(String name);
}
