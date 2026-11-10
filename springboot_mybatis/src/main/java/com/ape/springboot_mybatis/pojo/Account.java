package com.ape.springboot_mybatis.pojo;

import com.ape.springboot_mybatis.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private int aid;
    private int auserid;
    private double amoney;

    //一对一映射配置
    private User user;

}
