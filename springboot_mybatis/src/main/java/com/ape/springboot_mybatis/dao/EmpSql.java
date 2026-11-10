package com.ape.springboot_mybatis.dao;

import com.ape.springboot_mybatis.pojo.Emp;

public class EmpSql {


    public String findSql(Emp emp){
        String sql = "select * from emp where 1 = 1 ";
        if(emp.getEname() != null){
            sql+=" and ename = #{ename}";
        }
        if(emp.getEgender() != null){
            sql+=" and egender = #{egender}";
        }
        return sql;
    }

}
