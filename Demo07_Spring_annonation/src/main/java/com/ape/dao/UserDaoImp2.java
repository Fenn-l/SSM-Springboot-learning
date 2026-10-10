package com.ape.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp2 implements IUserDao {

    public void saveUser() {
        System.out.println("dao2层进行数据库的新增");
    }
}
