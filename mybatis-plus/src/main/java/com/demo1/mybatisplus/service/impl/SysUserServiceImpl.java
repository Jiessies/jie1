package com.demo1.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo1.mybatisplus.mapper.SysUserMapper;
import com.demo1.mybatisplus.mode.SysUser;
import com.demo1.mybatisplus.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends
        ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
