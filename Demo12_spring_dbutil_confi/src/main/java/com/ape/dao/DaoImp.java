package com.ape.dao;

import com.ape.bean.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public class DaoImp implements IDao{
    @Autowired
    QueryRunner queryRunner;
    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account values(null,?,?)",account.getAname(),account.getAmoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteById(int id) {
        try {
            queryRunner.update("delete from account where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Account findAccountByName(String aname) {
        try {
            return queryRunner.query("select * from account where name = ?",new BeanHandler<Account>(Account.class),aname);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateAccountById(Account account) {
        try {
            queryRunner.update("update account set name = ?,money = ? where id = ?",account.getAname(),account.getAmoney(),account.getAid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Account> findAccount() throws SQLException {
        return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
    }
    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;

    }
}
