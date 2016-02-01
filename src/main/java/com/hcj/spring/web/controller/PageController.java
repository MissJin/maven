package com.hcj.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/12/10.
 */
@Controller
@RequestMapping("/page")
public class PageController {
    /**
     *登录页
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    /**
     *dashboard页
     * @return
     */
    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
    /**
     *404页
     * @return
     */
    @RequestMapping("/404")
    public String error404(){
        return "404";
    }
    /**
     *401页
     * @return
     */
    @RequestMapping("/401")
    public String error401(){
        return "401";
    }
    /**
     *500页
     * @return
     */
    @RequestMapping("/500")
    public String error500(){
        return "500";
    }

}
