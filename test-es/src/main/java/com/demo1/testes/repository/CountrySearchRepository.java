package com.demo1.testes.repository;

import com.demo1.testes.domain.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CountrySearchRepository extends ElasticsearchRepository<Country, Long> {
    List<Country> findCountryByName(String name);

    //使用 Page<Country> countrys = countrySearchRepository.findByName("测试",  PageRequest.of(0, 10)); //分页是从0开始的
    Page<Country> findCountryByName(String name, Pageable pageable);

    Country findCountryById(String name);
}
