package com.ape.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "th")
public class Teacher {

//    @Value("刘老师")
//    private String tname;
//    @Value("40")
//    private int tage;

    @Value("${name}")
    private String tname;
    @Value("${age}")
    private int tage;

    @Override
    public String toString() {
        return "Teacher{" +
                "tname='" + tname + '\'' +
                ", tage=" + tage +
                '}';
    }
}
