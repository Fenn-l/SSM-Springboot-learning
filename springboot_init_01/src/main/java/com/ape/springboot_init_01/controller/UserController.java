package com.ape.springboot_init_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping(path = "/requestOne")
    @ResponseBody
    public String requestMethod(){
        System.out.println("进入controller控制器 处理用户请求");
        System.out.println("调用service 调用dao");
        return "处理用户请求结束";
    }
}
