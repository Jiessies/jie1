package com.demo1.testmongo.controller;

import com.demo1.testmongo.domain.Authority;
import com.demo1.testmongo.domain.AuthorityVO;
import com.demo1.testmongo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "test-mongo")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/findAll")
    public AuthorityVO findAll(int page, int limit) {
        AuthorityVO authorityVO = new AuthorityVO();
        authorityVO.setCode(0);
        authorityVO.setMsg("");
        authorityVO.setCount(authorityService.count());
        authorityVO.setData(authorityService.findAll(page, limit));
        return authorityVO;
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(@RequestBody Authority authority) {
        authorityService.save(authority);
        return "success";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        authorityService.delete(id);
        return "success";
    }

    @RequestMapping("/find")
    public Object find(@RequestParam("id") String id) {
        return authorityService.find(id);
    }
}
