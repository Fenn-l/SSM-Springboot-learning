package com.ape.springboot_mybatis;

import com.ape.springboot_mybatis.dao.AccountDao;
import com.ape.springboot_mybatis.dao.EmpDao;
import com.ape.springboot_mybatis.dao.UserDao;
import com.ape.springboot_mybatis.pojo.Account;
import com.ape.springboot_mybatis.pojo.Emp;
import com.ape.springboot_mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 运行前请先执行 sql/init.sql 建库建表。
 * 控制台会打印 MyBatis 执行的SQL（见 application.properties 的 log-impl 配置）。
 */
@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private EmpDao empDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    @Test
    void contextLoads() {
    }

    // ---------- EmpDao：单表 CRUD ----------

    @Test
    void testFindAllEmp() {
        List<Emp> list = empDao.findAll();
        list.forEach(System.out::println);
    }

    @Test
    void testFindById() {
        Emp emp = empDao.findById(1);
        System.out.println(emp);
    }

    @Test
    void testFindByNameAndGender() {
        List<Emp> list = empDao.findByNameAndGender("张无忌", "男");
        list.forEach(System.out::println);
    }

    /**
     * 动态SQL：ename 和 egender 传 null 时不加条件，
     * 传值时自动拼接。注意观察控制台打印的最终 SQL。
     */
    @Test
    void testDynamicSql() {
        Emp query = new Emp(null, null, 0);
        System.out.println("--- 不传条件：查全部 ---");
        empDao.findSql(query).forEach(System.out::println);

        query.setEname("张无忌");
        System.out.println("--- 只传 ename ---");
        empDao.findSql(query).forEach(System.out::println);

        query.setEgender("男");
        System.out.println("--- 两个条件都传 ---");
        empDao.findSql(query).forEach(System.out::println);
    }

    /**
     * 自增主键回填：插入后 emp.getEid() 就是数据库生成的主键。
     */
    @Test
    void testInsertAndGetGeneratedKey() {
        Emp emp = new Emp("测试员工", "男", 8888);
        int rows = empDao.saveEmpBackOne(emp);
        System.out.println("影响行数 = " + rows + "，回填主键 eid = " + emp.getEid());
    }

    /**
     * 一对一 —— 分步查询：先查account，再按 auserid 查 user。
     */
    @Test
    void testOneToOneStep() {
        List<Account> list = accountDao.findAllCashCade();
        list.forEach(a -> System.out.println(
                a.getAid() + " -> " + a.getUser().getUsername()));
    }

    /**
     * 一对一 —— 单步查询：一条SQL join 出全部数据。
     */
    @Test
    void testOneToOneJoin() {
        List<Account> list = accountDao.findAll();
        list.forEach(a -> System.out.println(
                a.getAid() + " " + a.getAmoney() + " -> " + a.getUser().getUsername()));
    }

    /**
     * 一对多：查用户时顺带把该用户的所有账户装配进去。
     * 这条测试验证 AccountDao 上的 @Mapper 是否生效。
     */
    @Test
    void testOneToMany() {
        List<User> users = userDao.findAllUser();
        users.forEach(u -> System.out.println(
                u.getUsername() + " 有 " + u.getAccounts().size() + " 个账户"));
    }
}