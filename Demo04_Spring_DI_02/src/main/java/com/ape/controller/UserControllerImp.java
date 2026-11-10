package com.ape.controller;

import com.ape.service.IUserService;

public class UserControllerImp implements IUserController {


    IUserService service = null;

    public void setService(IUserService service) {
        this.service = service;
    }

    public void saveUser() {
        System.out.println("controller层的用户新增");
        service.saveUser();
    }
}
