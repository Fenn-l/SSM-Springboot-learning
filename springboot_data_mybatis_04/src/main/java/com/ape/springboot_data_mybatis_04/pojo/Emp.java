package com.ape.springboot_data_mybatis_04.pojo;

import java.io.Serializable;


public class Emp implements Serializable{
    private int eid;
    private String ename;
    private String egender;
    private int esalary;

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", egender='" + egender + '\'' +
                ", esalary=" + esalary +
                '}';
    }

    public Emp() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Emp(int eid, String ename, String egender, int esalary) {
        super();
        this.eid = eid;
        this.ename = ename;
        this.egender = egender;
        this.esalary = esalary;
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
    public String getEgender() {
        return egender;
    }
    public void setEgender(String egender) {
        this.egender = egender;
    }
    public int getEsalary() {
        return esalary;
    }
    public void setEsalary(int esalary) {
        this.esalary = esalary;
    }

}
