package com.ape.springboot_data_mybatis_03.mapper;


import com.ape.springboot_data_mybatis_03.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface IAccountMapper {

    //按照账户ID查询账户以及用户数据
    public Account findAccountByAid(int aid);

    //一对多 按照用户id查询账户数据
    public List<Account> findAccountByUser(int userId);
}
