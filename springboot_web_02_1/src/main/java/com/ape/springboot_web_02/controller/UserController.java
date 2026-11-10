package com.ape.springboot_web_02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author 王老师
 * @since 2023/4/11
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    /**
     *
     *@RequestMapping
     * 意义:处理用户的请求
     * 位置:
     *      类上:一级目录
     *      方法:二级目录
     *      例如:user/save
     *          user/delete
     *          student/save
     *          student/delete
     *  属性:
     *      value = "",path = ""
     *      表示请求路径
     *      =========================
     *      method=常量,此请求的类型(get,post),若不设置则此请求适配所有的请求方式
     *      =========================
     *      params = ""
     *      限制请求参数,例如：params={"msg1","msg2"}表示请求路径中必须携带参数名为msg1与msg2的参数
     *
     *      注意:1.超链接默认发送的是get请求
     *          2.所有请求所携带的参数格式均为：key = value
     *
     *     @DeleteMapping删除
     *     @PutMapping   修改
     *     @GetMapping   查询
     *     @PostMapping  新增
     *
     *     @RequestMapping可以点击查看源码
     *     @Target({ElementType.METHOD, ElementType.TYPE})
     *          METHOD==代表修饰方法,TYPE==代表修饰类

     * */

    @RequestMapping(path="/init")//二级目录
    @ResponseBody
    public String userInit(){
        System.out.println("==========进入了springMVC的控制器=========");
        System.out.println("调用业务层，调用持久层");
        return "success";//返回方法执行完要跳转的页面名称
    }

    @RequestMapping(value="/show1",method ={RequestMethod.POST})
    @ResponseBody
    public String show1(){
        System.out.println("==========进入了springMVC的控制器=========");
        System.out.println("使用post方式发送请求进入");
        return "success";//返回方法执行完要跳转的页 面名称
    }


    //http://localhost:8080/user/show2?msg1=aa&msg2=bb
    @RequestMapping(value="/show2",params = {"msg1=aa","msg2=bb"})
    @ResponseBody
    public String show2(){
        System.out.println("==========进入了springMVC的控制器=========");
        System.out.println("限制请求携带的参数");
        return "success";//返回方法执行完要跳转的页面名称
    }


    //使用postman测试
    @GetMapping("/show3")
    @ResponseBody
    public String show3(){
        System.out.println("==========进入了springMVC的控制器=========");
        System.out.println("必须使用get方式请求");
        return "success";//返回方法执行完要跳转的页面名称
    }

    @PostMapping("/show4")
    @ResponseBody
    public String show4(){
        System.out.println("==========进入了springMVC的控制器=========");
        System.out.println("必须使用post方式请求");
        return "success";//返回方法执行完要跳转的页面名称
    }


    @DeleteMapping("/show5")
    @ResponseBody
    public String show5(){
        System.out.println("==========进入了springMVC的控制器=========");
        System.out.println("必须使用delete方式请求");
        return "success";//返回方法执行完要跳转的页面名称
    }

    @PutMapping("/show6")
    @ResponseBody
    public String show6(){
        System.out.println("==========进入了springMVC的控制器=========");
        System.out.println("必须使用put方式请求");
        return "success";//返回方法执行完要跳转的页面名称
    }

}
