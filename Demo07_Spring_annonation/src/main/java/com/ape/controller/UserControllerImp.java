package com.ape.controller;

import com.ape.service.IUserService;
import com.ape.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.util.Properties;

@Controller
public class UserControllerImp implements IUserController {


    @Autowired
    IUserService service;


    public void saveUser() {
        System.out.println("controller层的用户新增");
        service.saveUser();
    }
}
