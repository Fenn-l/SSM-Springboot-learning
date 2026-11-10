package com.ape.springboot_web_02_4.controller;


import com.ape.springboot_web_02_4.pojo.Emp;
import com.ape.springboot_web_02_4.pojo.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//@Controller
@RequestMapping("/json")
//@ResponseBody
@RestController
public class JsonController {

    /**
     *
     * @ResponseBody   对象====>json
     *  位置:1.类
     *      2.方法
     *
     *
     * @RequestBody    json====>对象
     * 位置:方法参数
     *
     * @RestController   =  @Controller  +  @ResponseBody
     *
     * */

    @RequestMapping("/show1")

    public List<Emp> show1(){
        //1模拟数据库
        Emp emp1 = new Emp(1,"张毅老师","男");
        Emp emp2 = new Emp(2,"张毅老师","男");
        Emp emp3 = new Emp(3,"张毅老师","男");
        List<Emp> list = new ArrayList<Emp>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        return list;
    }

    @RequestMapping("/show2")
    public String show2(){
        return "helloWorld";
    }

}
