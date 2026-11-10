package com.ape.springboot_web_02_3.controller;

import com.ape.springboot_web_02_3.pojo.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * springMVC常用注解
 *
 * 一.@RequestParam
 *      作用：
 *          把请求中指定名称的参数给控制器中的形参赋值。
 *          如果页面标签名称和方法参数名称不一致，可以使用此注解实现
 *      属性：
 *          name属性：设置参数名称
 *          defaultValue属性：设置默认值
 *          required属性：设置是否为必传
 *
 * 二.@RequestBody
 *      作用：
 *          用于获取"请求体"内容。直接使用得到是 key=value&key=value...
 *          结构的数据,并可以转换为对象
 *      属性：
 *          required：是否必须有请求体。默认值是:true。
 *
 *
 *
 * 三.@PathVaribale
 *      作用：
 *          用于绑定 url 中的占位符。例如：请求 url 中 /delete/{id}，
 *          这个{id}就是 url 占位符。url 支持占位符是 spring3.0 之
 *          后加入的。是 springmvc 支持 rest 风格 URL 的一个重要标志
 *      属性：
 *          value：用于指定 url 中占位符名称。
 *          required：是否必须提供占位符。
 *
 *  Restful是一种软件架构风格、设计风格，而不是标准，只是提供了一组设计原则和约束条件。
 *  主要用于客户端和服务器交互类的软件，基于这个风格设计的软件可以更简洁，更有层次，
 *  更易于实现缓存机制等。
 *
 *  Restful风格的请求是使用“url+请求方式”表示一次请求目的的，HTTP 协议里面四个表示操作方式的动词如下：
 *       GET：用于获取资源
 *       POST：用于新建资源
 *       PUT：用于更新资源
 *       DELETE：用于删除资源
 * 例如：
 *  /users/1                GET ：      得到 id = 1 的 user
 *  /users/1                DELETE：    删除 id = 1 的 user
 *  /users/1/新名/新性       PUT：       更新 id = 1 的 user
 *  /users/新名/新性         POST：      新增 user
 *
 *  http://localhost:8080/userSave?uid=101&uname=XX
 *
 *  post         http://localhost:8080/users/101/XX/xx
 *  get          http://localhost:8080/users/101
 *  delete       http://localhost:8080/users/101
 *  put          http://localhost:8080/users/101/XX
 * */


@Controller
@RequestMapping("/one")
@ResponseBody
public class OneController {


    /**
     * @RequestParam("名称必须与页面标签或者url地址key名称一致")
     * */
    @RequestMapping("/show1")
    public String show1(@RequestParam(name="msg1") String msg){
        System.out.println("=====接受到用户发送数据为:"+msg+"=======");
        return "success";
    }

    @RequestMapping("/show2")
    public String show2(@RequestParam("msg1") String msg, @RequestParam("msg2") int num){
        System.out.println("=====接受到用户发送数据为:"+msg+"=======");
        System.out.println("=====接受到用户发送数据为:"+num+"=======");
        return "success";
    }


    @RequestMapping("/show3")
    public String show3(@RequestParam(name = "uname",defaultValue = "暂无用户") String name){
        System.out.println("账号:"+name);
        return "success";
    }

//    @RequestMapping("/show4")
//    public String show4(@RequestParam String name){
//        System.out.println("账号:"+name);
//        return "success";
//    }


    /**
     * 前后端分离
     * @RequestBody可以将json ===》 javaBean
     * 注意:
     *  1.前端不能使用GET方式提交数据,GET方式无请求体
     * {
     * 	"eid":007,
     * 	"ename":"詹姆斯邦德",
     * 	"esex":"绅士"
     * }
     *
     * * */
    @RequestMapping("/show4")
    public String show4(@RequestBody Emp emp){
        System.out.println("=========="+emp+"==========");
        return "success";
    }



    @PostMapping("/show5/{uname}/{upwd}")
    public String show5(@PathVariable("uname") String msg1, @PathVariable("upwd") String msg2){
        System.out.println(msg1);
        System.out.println(msg2);
        return "success";
    }

    @PostMapping("/show6/{uname}/{pwd}")
    public String show6(@PathVariable String uname, @PathVariable String pwd){
        System.out.println(uname);
        System.out.println(pwd);
        return "success";
    }

}
