package com.ape.controller;

import com.ape.bean.Account;
import com.ape.service.IService;

import java.util.List;

public class ControllerImp implements IController{
    IService service;
    public void setService(IService service) {
        this.service = service;
    }

    public List<Account> findAccount() {
        return service.findAccount();
    }

    public void saveAccount(Account account) {
        service.saveAccount(account);
    }

    public void deleteById(int id) {
        service.deleteById(id);
    }

    public Account findAccountByName(String aname) {
        return service.findAccountByName(aname);
    }

    public void updateAccountById(Account account) {
        service.updateAccountById(account);
    }
}
