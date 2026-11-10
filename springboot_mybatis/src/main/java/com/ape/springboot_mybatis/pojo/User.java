package com.ape.springboot_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private int userid;
    private String username;
    private String usersex;
    private String useraddress;
    private Date userbirthday;

    //一对多
    private List<Account> accounts;


}
