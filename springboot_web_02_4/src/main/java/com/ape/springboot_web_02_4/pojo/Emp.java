package com.ape.springboot_web_02_4.pojo;

import java.io.Serializable;

public class Emp implements Serializable {


    private int eid;
    private String ename;
    private String esex;


    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
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


    public Emp() {
    }

    public Emp(int eid, String ename, String esex) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
    }
}
