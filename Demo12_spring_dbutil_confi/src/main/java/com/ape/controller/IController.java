package com.ape.controller;

import com.ape.bean.Account;

import java.util.List;

public interface IController {
    public void saveAccount(Account account);
    public void deleteById(int id);
    public Account findAccountByName(String aname);
    public void updateAccountById(Account account);
    public List<Account> findAccount();
}
