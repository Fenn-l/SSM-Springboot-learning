package com.ape.springboot_mybatis.dao;

import com.ape.springboot_mybatis.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountDao {
    /**
     * 单步查询
     * *
     * 注意：a.* 和 u.* 会在列名重复时互相覆盖，这里显式列出列名更安全。
     * */
    @Select("SELECT a.aid, a.auserid, a.amoney, u.username, u.usersex, u.useraddress, u.userbirthday " +
            "FROM account a JOIN user u ON a.auserid = u.userid")
    @Results(id="map1",value={
            @Result(id = true,property = "aid",column = "aid"),
            @Result(id = false,property = "auserid",column = "auserid"),
            @Result(id = false,property = "amoney",column = "amoney"),
            @Result(id = false,property = "user.username",column = "username"),
            @Result(id = false,property = "user.usersex",column = "usersex"),
            @Result(id = false,property = "user.useraddress",column = "useraddress"),
            @Result(id = false,property = "user.userbirthday",column = "userbirthday")
    })
    public List<Account> findAll();
    /**
     * 分步查询
     *
     * 一对一的注解实现：
     * one=@One(select = "命名空间.方法"）
     *
     * 一对多的注解实现：
     * many=@Many(select = "命名空间.方法"）
     *
     * */
    @Select("select * from account")
    @Results(id="map2",value={
            @Result(id = true,property = "aid",column = "aid"),
            @Result(id = false,property = "auserid",column = "auserid"),
            @Result(id = false,property = "amoney",column = "amoney"),
            @Result(id=false,column = "auserid",property = "user",one = @One(select = "com.ape.springboot_mybatis.dao.UserDao.findUserById"))
    })
    public List<Account> findAllCashCade();

    @Select("select * from account where auserid = #{userid}")
    public List<Account> findAccountByUserId(@Param("userid") int userid);

}
