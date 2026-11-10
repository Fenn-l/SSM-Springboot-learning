package com.ape.springboot_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * emp 表实体
 * eid / ename / egender / esalary
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp implements Serializable {

    private int eid;
    private String ename;
    private String egender;
    private int esalary;

    /**
     * 插入用的构造器（不含自增主键）
     */
    public Emp(String ename, String egender, int esalary) {
        this.ename = ename;
        this.egender = egender;
        this.esalary = esalary;
    }
}