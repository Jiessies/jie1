package com.demo1.mybatisplus;

import com.demo1.mybatisplus.mapper.SysUserMapper;
import com.demo1.mybatisplus.mode.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.TreeSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void contextLoads() {
        TreeSet set = new TreeSet();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
        SysUser sysUser = sysUserMapper.selectById(18);
        System.out.println(sysUser.getNickname());
        SysUser sysUser1 = sysUserMapper.selectById(18);
        System.out.println(sysUser1.getNickname());
        sqlSession.close();
    }

}
