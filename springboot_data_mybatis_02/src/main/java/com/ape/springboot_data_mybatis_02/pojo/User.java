package com.ape.springboot_data_mybatis_02.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class User implements Serializable {

    private Integer userid;
    private String username;
    private String useraddress;
    private String usersex;
    private Date userbirthday;

    //一对多关系映射
    private List<Account> accounts;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userbirthday=" + userbirthday +
                ", accounts=" + accounts +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public Date getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public User() {
    }

    public User(Integer userid, String username, String useraddress, String usersex, Date userbirthday, List<Account> accounts) {
        this.userid = userid;
        this.username = username;
        this.useraddress = useraddress;
        this.usersex = usersex;
        this.userbirthday = userbirthday;
        this.accounts = accounts;
    }
}
