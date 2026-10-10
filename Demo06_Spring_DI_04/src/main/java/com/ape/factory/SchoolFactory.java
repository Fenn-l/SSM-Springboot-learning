package com.ape.factory;

import com.ape.bean.School;
import com.ape.bean.Teacher;

public class SchoolFactory {

    public static School createSchool(){
        System.out.println("执行静态工厂的静态方法进行对象创建");
        return new School();
    }

}
