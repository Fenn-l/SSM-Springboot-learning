package com.ape.springboot_data_mybatis_02;

import com.ape.springboot_data_mybatis_02.mapper.IAccountMapper;
import com.ape.springboot_data_mybatis_02.mapper.IUserMapper;
import com.ape.springboot_data_mybatis_02.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDataMybatis02ApplicationTests {
    @Autowired
    IAccountMapper accountMapper;
    @Autowired
    IUserMapper userMapper;

    @Test
    void contextLoads() {
//        Account accountByAid = accountMapper.findAccountByAid(1);
//        System.out.println(accountByAid);
        User userByUid = userMapper.findUserByUid(1);
        System.out.println(userByUid);
    }
}
