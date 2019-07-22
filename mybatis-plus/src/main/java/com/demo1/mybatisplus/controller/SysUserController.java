package com.demo1.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo1.mybatisplus.mode.SysUser;
import com.demo1.mybatisplus.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @GetMapping(value = "/test")
    public void test(){
        //测试逻辑删除功能
        SysUser sysUser = (SysUser) sysUserService.selectById(1);

        //测试分页
        IPage<SysUser> sysUserIPage = sysUserService.selectPage(
                new Page<SysUser>(1, 10), new QueryWrapper<>());


        //测试公共字段自动填充
        SysUser sysUser1 = new SysUser();
        sysUser1.setUsername("shen");
        sysUser1.setNickname("shen");
        sysUser1.setPassword("shen");
        sysUserService.insert(sysUser1);

        //测试乐观锁
        SysUser sysUser2 = new SysUser();
        sysUser2.setId(19);
        sysUser2.setUsername("shen2");
        sysUser2.setNickname("shen2");
        sysUser2.setPassword("shen2");
        sysUser2.setUpdateVersion(1);

        sysUserService.updateById(sysUser2);

    }

    @GetMapping(value = "/batch")
    public String batch(){

        ArrayList list = new ArrayList();

        SysUser sysUser1 = new SysUser();
        sysUser1.setUsername("shen");
        sysUser1.setNickname("shen");
        sysUser1.setPassword("shen");
        list.add(sysUser1);

        SysUser sysUser2 = new SysUser();
        sysUser2.setId(19);
        sysUser2.setUsername("shen2");
        sysUser2.setNickname("shen2");
        sysUser2.setPassword("shen2");
        sysUser2.setUpdateVersion(1);
        list.add(sysUser2);

        SysUser sysUser3 = new SysUser();
        sysUser3.setId(19);
        sysUser3.setUsername("shen3");
        sysUser3.setNickname("shen3");
        sysUser3.setPassword("shen3");
        sysUser3.setUpdateVersion(1);
        list.add(sysUser3);

        SysUser sysUser4 = new SysUser();
        sysUser4.setId(19);
        sysUser4.setUsername("shen4");
        sysUser4.setNickname("shen4");
        sysUser4.setPassword("shen4");
        sysUser4.setUpdateVersion(1);
        list.add(sysUser4);

        SysUser sysUser5 = new SysUser();
        sysUser5.setId(19);
        sysUser5.setUsername("shen2");
        sysUser5.setNickname("shen2");
        sysUser5.setPassword("shen2");
        sysUser5.setUpdateVersion(1);
        list.add(sysUser5);

        Boolean b = sysUserService.insertOrUpdateBatch(list, 3);
        return String.valueOf(b);
    }

    @GetMapping(value = "/update")
    public String updateBatch(){


        List list = new ArrayList();
        SysUser sysUser = new SysUser();
        sysUser.setId(18);
        sysUser.setUsername("huangmingjie");
        list.add(sysUser);

        SysUser sysUser2 = new SysUser();
        sysUser2.setId(19);
        sysUser2.setUsername("huangmingjie");
        list.add(sysUser2);


        SysUser sysUser3 = new SysUser();
        sysUser3.setId(20);
        sysUser3.setUsername("huangmingjie");
        list.add(sysUser3);



        Boolean b = sysUserService.updateBatchById(list);
        return String.valueOf(b);

    }
}
