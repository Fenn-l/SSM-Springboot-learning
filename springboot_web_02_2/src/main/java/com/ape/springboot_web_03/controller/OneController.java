package com.ape.springboot_web_03.controller;

import com.ape.springboot_web_03.pojo.Emp;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping("/one")
@ResponseBody
public class OneController {
    @RequestMapping("/show1")
    public String show1(String msg1){
        System.out.println("=====接受到用户发送数据为:"+msg1+"=======");
        return "success";
    }
    @RequestMapping("/show2")
    public String show2(String msg1,int msg2){
        System.out.println("=====接受到用户发送数据为:"+msg1+"=======");
        System.out.println("=====接受到用户发送数据为:"+msg2+"=======");
        return "success";
    }

    /***********************POJO 类型作为参数*********************************/
    //单一对象
    @RequestMapping("/show3")
    public String show3(Emp emp){
        System.out.println("=====接受到用户发送数据为:"+emp+"=======");
        return "success";
    }
    //对象嵌套
    @RequestMapping("/show4")
    public String show4(Emp emp){
        System.out.println("=====接受到用户发送数据为:"+emp+"=======");
        return "success";
    }

    /*********************POJO 类中包含集合类型参数*********************************/
    @RequestMapping("/show6")
    public String show8(int[] nums){
        System.out.println("=====接受到用户发送数据为:"+ Arrays.toString(nums) +"=======");
        return "success";
    }

    /*********************使用 ServletAPI 对象作为方法参数*********************************/
    @RequestMapping("/show7")
    public String show7(HttpServletRequest request, HttpServletResponse response){


//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
        System.out.println(request);
        System.out.println(response);
        request.getParameter("msg1");

        HttpSession session =     request.getSession();
        System.out.println(session);
        session.setAttribute("","");

//        try {
//            response.sendRedirect("重定向");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ServletContext applaction =  session.getServletContext();

        return "success";
    }


}
