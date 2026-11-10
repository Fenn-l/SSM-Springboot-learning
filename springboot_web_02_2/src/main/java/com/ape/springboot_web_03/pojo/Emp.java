package com.ape.springboot_web_03.pojo;

import java.io.Serializable;

public class Emp implements Serializable {


    private int eid;
    private String ename;
    private String esex;


    //emp依赖的dep对象
    private Dep dept;

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", dept=" + dept +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public Dep getDept() {
        return dept;
    }

    public void setDept(Dep dept) {
        this.dept = dept;
    }
}
