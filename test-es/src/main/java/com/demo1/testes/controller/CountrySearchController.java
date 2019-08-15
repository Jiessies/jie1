package com.demo1.testes.controller;

import com.demo1.testes.domain.Country;
import com.demo1.testes.domain.User;
import com.demo1.testes.repository.UserSearchRepository;
import com.demo1.testes.service.CountrySearchService;
import com.demo1.testes.service.ESService;
import com.demo1.testes.service.TestHikariService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/estest")
public class CountrySearchController {

    @Autowired
    private CountrySearchService countrySearchService;

    @Autowired
    private ESService esService;

    @Autowired
    private UserSearchRepository repository;

    @Autowired
    private TestHikariService testHikariService;

    @RequestMapping(value = "/getCountry")
    public Page<Country> getCountryByName(@RequestParam String name) {
        return countrySearchService.getCountryByName(name);
    }

    @RequestMapping(value = "/addIndex")
    public String addIndex() {
        esService.createIndex(Country.class);
        return "success";
    }

    @RequestMapping(value = "/init")
    public String init() {
        String resonse = StringUtils.EMPTY;
        Boolean b = esService.createIndex(User.class);
        if (b) {
            User user = new User();
            user.setCreateDate(new Date());
            user.setPassword("12345678");
            user.setRemark("jasonJ");
            user.setUsername("huangmingjie");
            user.setId(1L);
            Boolean b0 = esService.insertOrUpdate(user);
            if (b0) {
                resonse = "success";
            } else {
                resonse = "fail";
            }
        } else {
            resonse = "fail";
        }

        return resonse;
    }

    @RequestMapping(value = "/query")
    public User query(@RequestParam Long id) {
        return repository.findUserById(id);
    }

    @RequestMapping(value = "/allUser")
    public List<com.demo1.testes.mode.User> selectAllUser() {
        return testHikariService.selectAllUser();
    }
}
