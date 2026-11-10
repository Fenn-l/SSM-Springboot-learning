package com.ape.service;


import com.ape.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements IAccountService {


    public void save(int i) {
        System.out.println("业务层的新增方法:"+i);
    }

    public void update() {
        System.out.println("业务层的修改方法");
        //int a = 10/0;

    }

    public int delete() {
        System.out.println("业务层的删除方法");
        return 0;
    }
}
