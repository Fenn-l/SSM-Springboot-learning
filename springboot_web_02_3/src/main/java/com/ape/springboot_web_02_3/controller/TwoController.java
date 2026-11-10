package com.ape.springboot_web_02_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * springMVC常用注解
 *
 * 四.@RequestHeader
 *      作用：
 *          用于获取请求消息头。
 *      属性：
 *          value：提供消息头名称
 *          required：是否必须有此消息头
 * */


@Controller
@RequestMapping("/two")
public class TwoController {



    /**
     * 获取头信息
     * 只获取头信息中的Accept-Language对应的数据(记得使用浏览器测试)
     * */
    @RequestMapping("/show1")
    public String show1(@RequestHeader(value="msg1") String msg){
        System.out.println(msg);
        return "success";
    }


}
