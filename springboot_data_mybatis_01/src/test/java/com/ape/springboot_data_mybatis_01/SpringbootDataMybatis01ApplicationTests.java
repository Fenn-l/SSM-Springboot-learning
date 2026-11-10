package com.ape.springboot_data_mybatis_01;

import com.ape.springboot_data_mybatis_01.mapper.StudentMapper;
import com.ape.springboot_data_mybatis_01.pojo.QueryParam;
import com.ape.springboot_data_mybatis_01.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootDataMybatis01ApplicationTests {

    @Autowired
    StudentMapper studentMapper;
    @Test
    void contextLoads() {
//       List<Student> all= studentMapper.findAll();
//       for (Student student : all) {
//           System.out.println(student);
//       }
    }
    @Test
    void contextLoads2() {
        List<Student> all= studentMapper.findByName("张三");
        for (Student student : all) {
            System.out.println(student);
        }
    }
    @Test
    void contextLoads3() {
        Student stu1 =studentMapper.findById(1);
        System.out.println(stu1);
    }
    @Test
    void contextLoads4() {
        Map<String,String> map=new HashMap<>();
        map.put("name","张三");
        map.put("sex","男");
        Student stu1 =studentMapper.findByMessage1(map);
        System.out.println(stu1);
    }
    @Test
    void contextLoads5() {
        QueryParam qp=new QueryParam(1,2);
        List<Student> students= studentMapper.findByMessage2(qp);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    void contextLoads6() {
        List<Student> students=studentMapper.findAllOne();
        System.out.println(students);
    }
    @Test
    @Rollback(false)
    void contextLoads7() {
        Student stu=new Student();
        stu.setStuName("三毛");
        stu.setStuSex("男");
        stu.setStuHobby("看电影");
        int insert = studentMapper.insertStudent(stu);
        System.out.println(insert);
    }
    @Test
    @Rollback(false)
    void contextLoads8() {
        Student stu=new Student();
        stu.setStuName("阿安");
        stu.setStuSex("男");
        stu.setStuHobby("看电影");
        int insert = studentMapper.insertStudentGeneratedOne(stu);
        System.out.println(insert);
    }
    @Test
    @Rollback(false)
    void contextLoads9() {
        Student stu=new Student();
        stu.setStuId(4);
        stu.setStuName("三毛");
        stu.setStuSex("男");
        stu.setStuHobby("打球");
        int update = studentMapper.updateById(stu);
        System.out.println(update);
    }
    @Test
    @Rollback(false)
    void contextLoads10() {
        int delete = studentMapper.deleteById(5);
        System.out.println(delete);
    }
}
