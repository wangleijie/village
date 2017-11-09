package com.lanou.controller;


import com.lanou.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by dllo on 17/11/7.
 */
@Controller
public class MainController {

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


}
