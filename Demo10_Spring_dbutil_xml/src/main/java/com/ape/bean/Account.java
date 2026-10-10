package com.ape.bean;

import java.io.Serializable;

public class Account implements Serializable {
    private int aid;
    private String aname;
    private int amoney;


    public Account() {
    }

    public Account(int aid, String aname, int amoney) {
        this.aid = aid;
        this.aname = aname;
        this.amoney = amoney;
    }
    public Account( String aname, int amoney) {
        this.aname = aname;
        this.amoney = amoney;
    }

    /**
     * 获取
     * @return aid
     */
    public int getAid() {
        return aid;
    }

    /**
     * 设置
     * @param aid
     */
    public void setAid(int aid) {
        this.aid = aid;
    }

    /**
     * 获取
     * @return aname
     */
    public String getAname() {
        return aname;
    }

    /**
     * 设置
     * @param aname
     */
    public void setAname(String aname) {
        this.aname = aname;
    }

    /**
     * 获取
     * @return amoney
     */
    public int getAmoney() {
        return amoney;
    }

    /**
     * 设置
     * @param amoney
     */
    public void setAmoney(int amoney) {
        this.amoney = amoney;
    }

    public String toString() {
        return "Account{aid = " + aid + ", aname = " + aname + ", amoney = " + amoney + "}";
    }
}
