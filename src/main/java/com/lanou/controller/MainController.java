package com.lanou.controller;



import com.lanou.bean.SysUser;
import com.lanou.service.SysUserService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/7.
 */
@Controller
public class MainController {

    @Resource
    private SysUserService sysUserService;



    @RequestMapping(value = "/")
    public String font(){
        return "index";
    }


    @RequestMapping(value = "/login")
    public String a(){
        return "login";
    }

    @RequestMapping(value = "/welcome")
    public String b(){
        return "welcome";
    }

    @RequestMapping(value = "/admin")
    public String admin(){return "admin-list";}


    @ResponseBody
    @RequestMapping(value = "/findall")
    public AjaxResult findAll(){
        SysUser user=new SysUser();
        System.out.println(user.getUsername());
        List<SysUser> all = sysUserService.findAll();
        System.out.println(all);
        return new AjaxResult(all);
    }

    public SysUserService getSysUserService() {
        return sysUserService;
    }

    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @Override
    public String toString() {
        return "MainController{" +
                "sysUserService=" + sysUserService +
                '}';
    }
}
