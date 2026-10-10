package com.ape.controller;

import com.ape.service.IUserService;

public class UserControllerImp implements IUserController{
    IUserService userService;

    public UserControllerImp(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void saveUser() {

    }
}
