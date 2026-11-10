package com.ape.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//@Primary
public class UserDaoImp implements IUserDao {

    public void saveUser() {
        System.out.println("dao1层进行数据库的新增");
    }
}
