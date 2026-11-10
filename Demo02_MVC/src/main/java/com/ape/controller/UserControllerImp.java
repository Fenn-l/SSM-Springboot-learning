package com.ape.controller;

import com.ape.factory.BeansFactory;
import com.ape.service.IUserService;

public class UserControllerImp implements IUserController{
    IUserService service = (IUserService) BeansFactory.getBean("service");
    public void addUser() {
        System.out.println("controller层的用户新增");
        service.addUser();
    }


}
