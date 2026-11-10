package com.ape.dao;

import com.ape.bean.Account;

import java.sql.SQLException;
import java.util.List;

public interface IDao {
    public void saveAccount(Account account);
    public void deleteById(int id);
    public Account findAccountByName(String aname);
    public void updateAccountById(Account account);
    public List<Account> findAccount() throws SQLException;
}
