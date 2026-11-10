package com.ape.springboot_data_mybatis_03.mapper;


import com.ape.springboot_data_mybatis_03.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserMapper {

    /**
     * 查询一个用户，同时获取到用户下所有账户的信息
     */
    User findUserByUid(int uid);

    /**
     * 分步一对多展示
     * */
    User findUserByUids(int uid);


}
