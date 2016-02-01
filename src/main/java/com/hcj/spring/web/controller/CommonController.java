package com.hcj.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/12/10.
 */
@Controller
public class CommonController {
    @RequestMapping("index")
    public String index(HttpServletRequest request){
        return "index";
    }
}
