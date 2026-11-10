package com.ape.springboot_data_mybatis_01.mapper;

import com.ape.springboot_data_mybatis_01.pojo.QueryParam;
import com.ape.springboot_data_mybatis_01.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    public List<Student> findAll();
    public List<Student> findByName(String name);
    public Student findById(int id);
    public Student findByMessage1(Map<String,String> map);
    public List<Student> findByMessage2(QueryParam qp);
    public Integer findCount();

    //name="王%"
    public List<Student> findLikeNameOne(String name);

    //name="王"
    public List<Student> findLikeNameTwo(String name);

    public List<Student> findAllOne();
    public int insertStudent(Student stu);

    public int insertStudentGeneratedOne(Student stu);

    public int updateById(Student stu);

    public int deleteById(int id);
}
