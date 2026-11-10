package com.ape.springboot_mybatis.dao;

import com.ape.springboot_mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user where userid = #{userid}")
    public User findUserById(@Param("userid") int userid);
    @Select("select * from user")
    @Results(id = "map2",value = {
            @Result(id = true,property = "userid",column = "userid"),
            @Result(id = false,property = "username",column = "username"),
            @Result(id = false,property = "usersex",column = "usersex"),
            @Result(id = false,property = "useraddress",column = "useraddress"),
            @Result(id = false,property = "userbirthday",column = "userbirthday"),
            @Result(id = false,property = "accounts",column = "userid",
                    many = @Many(select = "com.ape.springboot_mybatis.dao.AccountDao.findAccountByUserId")
            )
    })
    public List<User> findAllUser();
}
