package com.ape.bean;

public class Student {
    private String stuName;
    private int stuAge;
    private double stuScore;

    public Student(String stuName, int stuAge, double stuScore) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuScore = stuScore;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", stuScore=" + stuScore +
                '}';
    }


}
