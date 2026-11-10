package com.ape.factory;

import com.ape.bean.Teacher;

public class TeacherFactory {

    public Teacher createTeacher(){
        System.out.println("执行工厂的方法进行对象创建");
        return new Teacher();
    }

}
