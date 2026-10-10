package com.ape.service;

import com.ape.controller.UserControllerImp;
import com.ape.dao.IUserDao;
import com.ape.dao.UserDaoImp;

import java.io.InputStream;
import java.util.Properties;

public class UserServiceImp implements IUserService{
    //耦合度低
    IUserDao dao = null;

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }

    public void saveUser() {
        System.out.println("service层进行业务新增");
        dao.saveUser();
    }
}
