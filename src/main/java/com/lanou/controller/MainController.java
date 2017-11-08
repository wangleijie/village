package com.lanou.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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


}
