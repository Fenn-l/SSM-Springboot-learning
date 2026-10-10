package com.ape.bean;

public class Dog {
    public Dog() {
        System.out.println("生命周期===>实例化");
    }

    public void initMethod(){
        System.out.println("生命周期===>初始化");
    }

    public void destoryMethod(){
        System.out.println("生命周期===>销毁了");
    }
}
