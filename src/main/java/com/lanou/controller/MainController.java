package com.lanou.controller;


import com.lanou.bean.SysRole;
import com.lanou.service.SysRoleService;
import com.lanou.service.impl.SysRoleServiceImpl;
import com.lanou.utils.AjaxResult;
import com.lanou.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by dllo on 17/11/7.
 */
@Controller
public class MainController {

@Resource
    private SysRoleService sysRoleService;


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

//    跳转到用户角色列表
    @RequestMapping(value = "/roles")
    public String roles(){
        return "admin-role";
    }



    @ResponseBody
    @RequestMapping(value = "/VerifyCode")
    public void VerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //用于处理真正的返回结果
        VerifyCode verifyCode=new VerifyCode();//创建工具类对象
        BufferedImage image=verifyCode.getImage();//验证码工具生成图片对象

//        将验证码保存在session中
        request.getSession().setAttribute("verifyCode",verifyCode.getText());


        //获得response对象的输出流用于图像的写入
        OutputStream os=response.getOutputStream();

        VerifyCode.output(image,os);//将图片对象映射到输出流中

    }




//    获得全部角色
    @ResponseBody
    @RequestMapping(value = "/getRolesAll")
    public AjaxResult getRolesAll(){

        List<SysRole> sysRoles = sysRoleService.getRolesAll();
        System.out.println(sysRoles);
        return new AjaxResult(sysRoles);
    }

}
