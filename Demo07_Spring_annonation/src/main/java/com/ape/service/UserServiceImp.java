package com.ape.service;

import com.ape.controller.UserControllerImp;
import com.ape.dao.IUserDao;
import com.ape.dao.UserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Properties;

@Service
public class UserServiceImp implements IUserService{
//    @Autowired
//    @Qualifier(value = "userDaoImp")
    @Resource(name="userDaoImp2")
    IUserDao dao;

    public void saveUser() {
        System.out.println("service层进行业务新增");
        dao.saveUser();
    }
}
