package com.ape.springboot_data_mybatis_04.mapper;


import com.ape.springboot_data_mybatis_04.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    public List<Emp> findOne(Emp emp);

    public List<Emp> findTwo(Emp emp);

    public List<Emp> findChoose(Emp emp);

    public List<Emp> findWhere(Emp emp);

    public void updateSet(Emp emp);

    public List<Emp> TrimOne(Emp emp);

    public void TrimTwo(Emp emp);

    public List<Emp> findByArray(int[] nums);

    public List<Emp> findByList(List<Integer> nums);

}
