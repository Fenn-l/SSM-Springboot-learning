package com.ape.springboot_data_mybatis_02.mapper;

import com.ape.springboot_data_mybatis_02.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface IAccountMapper {
    public Account findAccountByAid(int aid);

}
