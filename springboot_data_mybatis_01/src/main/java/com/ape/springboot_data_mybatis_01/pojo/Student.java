package com.ape.springboot_data_mybatis_01.pojo;

public class Student {
    private int stuId;
    private String stuName;
    private String stuSex;
    private String stuHobby;

    public Student() {
    }

    public Student(int stuId, String stuName, String stuSex, String stuHobby) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuHobby = stuHobby;
    }

    /**
     * 获取
     * @return stuId
     */
    public int getStuId() {
        return stuId;
    }

    /**
     * 设置
     * @param stuId
     */
    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    /**
     * 获取
     * @return stuName
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * 设置
     * @param stuName
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * 获取
     * @return stuSex
     */
    public String getStuSex() {
        return stuSex;
    }

    /**
     * 设置
     * @param stuSex
     */
    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    /**
     * 获取
     * @return stuHobby
     */
    public String getStuHobby() {
        return stuHobby;
    }

    /**
     * 设置
     * @param stuHobby
     */
    public void setStuHobby(String stuHobby) {
        this.stuHobby = stuHobby;
    }

    public String toString() {
        return "Student{stuId = " + stuId + ", stuName = " + stuName + ", stuSex = " + stuSex + ", stuHobby = " + stuHobby + "}";
    }
}
