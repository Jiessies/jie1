package com.demo1.dubboservice.mapper;

import com.demo1.dubbofacade.domain.DubboUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DubooMapper {

    @Select({"select * from user"})
    public List<DubboUser> findAllUser();
}
