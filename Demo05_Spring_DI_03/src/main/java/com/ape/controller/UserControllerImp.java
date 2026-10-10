package com.ape.controller;

import com.ape.service.IUserService;
import com.ape.service.UserServiceImp;

import java.io.InputStream;
import java.util.Properties;

public class UserControllerImp implements IUserController {


    IUserService service = null;

    public UserControllerImp(IUserService service) {
        this.service = service;
    }

    public void saveUser() {
        System.out.println("controller层的用户新增");
        service.saveUser();
    }
}
