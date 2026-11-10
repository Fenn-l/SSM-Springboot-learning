package com.ape.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志记录
 * */
@Component
@Aspect//切面
public class Logger {

    @Pointcut("execution(* com.ape.service.AccountServiceImp.update())")
    public void dian(){}

    //前置通知
    @Before("dian()")
    public void BeforeLogger(){
        System.out.println("前置通知==>日志类logger中调用BeforeLogger方法进行日志记录");
    }

    //返回通知
    @AfterReturning("dian()")
    public void AfterReturningLogger(){
        System.out.println("返回通知==>日志类logger中调用AfterReturningLogger方法进行日志记录");
    }

    //异常通知
    @AfterThrowing("dian()")
    public void AfterThrowingLogger(){
        System.out.println("异常通知==>日志类logger中调用AfterThrowingLogger方法进行日志记录");
    }

    //后置通知
    @After("dian()")
    public void AfterLogger(){
        System.out.println("后置通知==>日志类logger中调用AfterLogger方法进行日志记录");
    }

    //环绕通知
    //@Around("dian()")
    public Object AroundLogger(ProceedingJoinPoint pjp){
        Object returnobj = null;//保存主业务方法的返回值
        try{
            //1.前置通知
            System.out.println("环绕通知===》前置通知");

            Object[] objs = pjp.getArgs();//主业务方法的参数
            returnobj =  pjp.proceed(objs);//调用主业务方法


            //3.后置通知
            System.out.println("环绕通知===》后置通知");
        }catch (Throwable tw){
            //4.异常通知
            System.out.println("环绕通知===》异常通知");
        }finally{
            //5.最终通知
            System.out.println("环绕通知===》最终通知");
        }
        return returnobj;

    }




}
