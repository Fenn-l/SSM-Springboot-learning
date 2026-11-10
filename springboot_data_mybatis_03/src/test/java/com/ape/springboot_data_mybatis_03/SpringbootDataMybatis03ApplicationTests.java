package com.ape.springboot_data_mybatis_03;

import com.ape.springboot_data_mybatis_03.mapper.IAccountMapper;
import com.ape.springboot_data_mybatis_03.mapper.IUserMapper;
import com.ape.springboot_data_mybatis_03.pojo.Account;
import com.ape.springboot_data_mybatis_03.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDataMybatis03ApplicationTests {
    @Autowired
    IUserMapper userMapper;
    @Autowired
    IAccountMapper accountMapper;
    @Test
    void contextLoads() {
//        Account accountByAid = accountMapper.findAccountByAid(1);
//        System.out.println(accountByAid);
        User userByUid = userMapper.findUserByUids(1);
        System.out.println(userByUid);
    }
}
