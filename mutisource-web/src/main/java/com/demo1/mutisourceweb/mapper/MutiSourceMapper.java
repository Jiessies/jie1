package com.demo1.mutisourceweb.mapper;

import com.demo1.mutisourceweb.config.aop.DataSourceTypeAnnotation;
import com.demo1.mutisourceweb.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MutiSourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    @DataSourceTypeAnnotation(value = "WRITE")
    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //这个方式我自己加的
    @DataSourceTypeAnnotation(value = "READ")
    List<User> selectAllUser();
}
