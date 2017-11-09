package com.lanou.service.impl;

import com.lanou.bean.SysUser;
import com.lanou.mapper.SysUserMapper;
import com.lanou.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;



    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }
    public SysUserMapper getSysUserMapper() {
        return sysUserMapper;
    }

    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public String toString() {
        return "SysUserServiceImpl{" +
                "sysUserMapper=" + sysUserMapper +
                '}';
    }
}
