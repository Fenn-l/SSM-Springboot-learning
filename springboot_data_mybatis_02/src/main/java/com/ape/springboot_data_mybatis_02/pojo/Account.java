package com.ape.springboot_data_mybatis_02.pojo;

import java.io.Serializable;


public class Account implements Serializable {

    private Integer aid;
    private Integer auserid;
    private Double amoney;

    //一对一关系映射
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", auserid=" + auserid +
                ", amoney=" + amoney +
                ", user=" + user +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getAuserid() {
        return auserid;
    }

    public void setAuserid(Integer auserid) {
        this.auserid = auserid;
    }

    public Double getAmoney() {
        return amoney;
    }

    public void setAmoney(Double amoney) {
        this.amoney = amoney;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account() {
    }

    public Account(Integer aid, Integer userid, Double amoney, User user) {
        this.aid = aid;
        this.auserid = auserid;
        this.amoney = amoney;
        this.user = user;
    }
}
