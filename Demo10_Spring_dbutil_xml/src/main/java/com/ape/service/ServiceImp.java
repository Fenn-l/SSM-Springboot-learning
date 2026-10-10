package com.ape.service;

import com.ape.bean.Account;
import com.ape.dao.IDao;

import java.sql.SQLException;
import java.util.List;

public class ServiceImp implements IService{
    IDao dao;
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    public void saveAccount(Account account) {
        dao.saveAccount(account);
    }
    public void deleteById(int id) {
        dao.deleteById(id);
    }
    public Account findAccountByName(String aname) {
        return dao.findAccountByName(aname);
    }
    public void updateAccountById(Account account) {
        dao.updateAccountById(account);
    }
    public List<Account> findAccount() {
        try {
            return dao.findAccount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
