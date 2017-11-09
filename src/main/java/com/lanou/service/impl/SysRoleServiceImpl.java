package com.lanou.service.impl;

import com.lanou.bean.SysRole;
import com.lanou.mapper.SysRoleMapper;
import com.lanou.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
@Resource
    private SysRoleMapper sysRoleMapper;



    @Override
    public List<SysRole> getRolesAll() {
        return sysRoleMapper.getRolesAll();
    }
}
