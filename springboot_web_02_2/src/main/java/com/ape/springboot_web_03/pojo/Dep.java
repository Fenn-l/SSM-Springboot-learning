package com.ape.springboot_web_03.pojo;

public class Dep {
    private int did;
    private String dname;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Dep(int did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    public Dep() {
    }

    @Override
    public String toString() {
        return "Dep{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
