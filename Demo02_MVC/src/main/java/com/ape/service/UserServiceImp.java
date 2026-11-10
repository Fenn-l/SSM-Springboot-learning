package com.ape.service;

import com.ape.dao.IUserDao;
import com.ape.factory.BeansFactory;

public class UserServiceImp implements IUserService {
    IUserDao dao = (IUserDao) BeansFactory.getBean("dao");
    public void addUser() {
        System.out.println("service层进行业务新增");
        dao.addUser();
    }
}
