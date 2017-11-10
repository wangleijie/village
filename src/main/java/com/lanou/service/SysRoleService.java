package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.SysRole;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface SysRoleService {
    List<SysRole> getRolesAll();

    PageInfo<SysRole> getPageinfo(Integer pageNo, Integer pageSize);
}
