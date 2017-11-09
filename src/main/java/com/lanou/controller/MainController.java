package com.lanou.controller;

import com.lanou.bean.User;
import com.lanou.exception.CustomException;
import com.lanou.service.SysUserService;
import com.lanou.service.impl.SysUserServiceImpl;
import com.lanou.utils.AjaxResult;

import com.lanou.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    private SysUserService sysUserService;

    @RequestMapping(value = "/")
    public String font() {
        return "index";
    }

    @RequestMapping(value = "/welcome")
    public String b() {
        return "welcome";
    }


    // 验证码
    @RequestMapping(value = "/VerifyCode")
    public void VerifyCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 用于处理真正的返回结果
        VerifyCode verifyCode = new VerifyCode();//创建工具类对象
        BufferedImage image = verifyCode.getImage();//验证码工具生成图片对象

        // 将验证码保存在session中
        request.getSession().setAttribute("verifyCode", verifyCode.getText());

        // 获得response对象的输出流用于图像的写入
        OutputStream os = response.getOutputStream();

        // 将图片对象映射到输出流中
        VerifyCode.output(image, os);

    }


    // 登录
    @RequestMapping(value = "/login")
    public String login() {

        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "index";
        }
        return "login";
    }


    // 错误信息
    @RequestMapping(value = "/loginsubmit", method = RequestMethod.POST)
    public String loginsubmit(HttpServletRequest request) throws Exception {

//         shiro在认证过程中出现错误后, 将异常类路径通过request返回
        String exceptionClassName =
                (String) request.getAttribute("shiroLoginFailure");

        if (exceptionClassName.equals(UnknownAccountException.class.getName())) {

            throw new CustomException("账户名不存在");


        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {

            throw new CustomException("密码错误");


        }else if ("randomCodeError".equals(exceptionClassName)){

            throw new CustomException("验证码错误");
        }

        else {
            throw new Exception();
        }
    }


    // 显示全部
    @RequestMapping(value = "/admin_list")
    public String adminlist(){
        return "admin-list";
    }

    @ResponseBody
    @RequestMapping(value = "/getAdminlist")
    public AjaxResult adlist(){
        List<User> userList = sysUserService.findalladmin();
//        System.out.println(userList);
        return new AjaxResult(userList);

}





}
