package com.ape.test;

import com.ape.controller.IUserController;
import com.ape.controller.UserControllerImp;

public class test {
    public static void main(String[] args) {
        IUserController controller =  new UserControllerImp();
        controller.addUser();
    }
}
