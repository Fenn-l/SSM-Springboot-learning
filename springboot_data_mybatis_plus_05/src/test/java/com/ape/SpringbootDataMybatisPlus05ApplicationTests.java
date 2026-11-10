package com.ape;

import com.ape.mapper.UserMapper;
import com.ape.pojo.User;
import com.ape.pojo.UserQuery;
import com.ape.service.AsyncService;
import com.ape.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootDataMybatisPlus05ApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        //调用mybatis
//        List<User> allUser = userMapper.findAllUser();
//        for (int i = 0; i < allUser.size(); i++) {
//            User user =  allUser.get(i);
//            System.out.println(user);
//        }

        //调用mybatis-plus
        List<User> allUser = userMapper.selectList(null);
        for (int i = 0; i < allUser.size(); i++) {
            User user =  allUser.get(i);
            System.out.println(user);
        }
    }
    @Test
    void contextLoads2() {
        //1 创建IPage分页对象,设置分页参数,1为当前页码，3为每页显示的记录数
        IPage<User> page=new Page<User>(1,2);
        //2 执行分页查询
        userMapper.selectPage(page,null);
        //3 获取分页结果
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());
    }
    @Test
    void testGetAll(){
        QueryWrapper qw = new QueryWrapper();
        qw.lt("age",18);
        List<User> userList = userMapper.selectList(qw);
        System.out.println(userList);
    }
    @Test
    void testGetAll2(){
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<User>();
        lqw.lt(User::getAge,30);
        lqw.gt(User::getAge,10);
        List<User>userList=userMapper.selectList(lqw);
        System.out.println(userList);
    }
    @Test
    void testGetAll3(){
        UserQuery uq=new UserQuery();
        uq.setAge(10);
        uq.setAge2(30);
        LambdaQueryWrapper<User>lqw=new LambdaQueryWrapper<User>();lqw.lt(null!=uq.getAge2(),User::getAge,uq.getAge2());
        lqw.gt(null!=uq.getAge(),User::getAge,uq.getAge());
        List<User>userList=userMapper.selectList(lqw);
        System.out.println(userList);
    }
    @Test
    void testDelete(){
        userMapper.deleteById(4L);
        System.out.println(userMapper.selectList(null));
    }
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(3L);
        user.setName("Jock");
        user.setVersion(1);
        userMapper.updateById(user);
    }
    @Test
    void testUpdate2(){
//1.先通过要修改的数据id将当前数据查询出来
        User user = userMapper.selectById(3L);
//2.将要修改的属性逐一设置进去
        user.setName("Jock888");
        userMapper.updateById(user);
    }
    @Test
    void testUpdate3(){
        //1.先通过要修改的数据id将当前数据查询出来
        User user = userMapper.selectById(2L); //version=3
        User user2 = userMapper.selectById(2L); //version=3
        user2.setName("jerry aaa");
        userMapper.updateById(user2); //version=>4
        user.setName("jerry bbb");
        userMapper.updateById(user); //verion=3?条件还成立吗？
    }

    //==================== 事务管理测试 ====================

    @Autowired
    IUserService userService;

    /**
     * 事务测试1：正常新增，事务提交后数据保留
     */
    @Test
    void testInsert() {
        User user = new User();
        user.setName("事务测试A");
        user.setAge(20);
        user.setTel("13900000001");
        userService.insertUser(user);
        System.out.println("【事务测试1】新增完成：");
        userMapper.selectList(null);
    }

    /**
     * 事务测试2：批量新增中途抛异常，验证【整体回滚】
     * 预期：两条数据都不会留在库中
     */
    @Test
    void testInsertBatchWithRollback() {
        User user1 = new User();
        user1.setName("事务测试B1");
        user1.setAge(21);
        user1.setTel("13900000002");

        User user2 = new User();
        user2.setName("事务测试B2");
        user2.setAge(22);
        user2.setTel("13900000003");

        try {
            //该方法内部会抛 RuntimeException
            userService.insertUsersBatch(user1, user2);
            System.out.println("【事务测试2】未抛出异常（不符合预期）");
        } catch (Exception e) {
            System.out.println("【事务测试2】捕获到异常：" + e.getMessage());
            System.out.println("【事务测试2】事务已回滚，user1/user2 均未插入成功");
        }
        //打印当前库中数据，人工确认没有“事务测试B*”的残留
        List<User> list = userMapper.selectList(null);
        System.out.println("【事务测试2】当前库中数据：");
        list.forEach(u -> System.out.println(u));
    }

    /**
     * 事务测试3：逻辑删除（本质是 update，走事务）
     */
    @Test
    void testDeleteInTransaction() {
        userService.deleteUser(5L);
        System.out.println("【事务测试3】删除后可见数据：");
        userMapper.selectList(null);
    }

    /**
     * 事务测试4：乐观锁更新（先查后改，version 自动 +1）
     */
    @Test
    void testUpdateInTransaction() {
        //先查询，拿到 version
        User user = userMapper.selectById(3L);
        System.out.println("【事务测试4】更新前 version = " + user.getVersion());
        user.setName("事务更新后的名字");
        userService.updateUser(user);
        System.out.println("【事务测试4】更新完成");
    }

    //==================== 异步任务测试 ====================

    @Autowired
    AsyncService asyncService;

    /**
     * 异步测试1：无返回值
     * 预期：主线程（测试线程）很快结束，【异步】日志在之后由其他线程打印
     */
    @Test
    void testAsyncSendSms() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncService.sendSms(1);
        long cost = System.currentTimeMillis() - start;
        System.out.println("【异步测试1】主线程调用耗时：" + cost + "ms（远小于异步线程内的500ms）");
        Thread.sleep(800);   // 等异步线程执行完再看结果
    }

    /**
     * 异步测试2：有返回值 CompletableFuture
     */
    @Test
    void testAsyncSendEmail() throws Exception {
        CompletableFuture<String> future = asyncService.sendEmailAsync(2);
        System.out.println("【异步测试2】已提交异步邮件任务，主线程继续执行...");
        String result = future.get(5, TimeUnit.SECONDS);   // 等待并获取结果
        System.out.println("【异步测试2】拿到异步执行结果：" + result);
    }

    /**
     * 异步测试3：批量发送，验证并发执行（5个任务并发，总耗时约500ms而非2500ms）
     */
    @Test
    void testAsyncBatch() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncService.batchSendSms(asyncService);
        long cost = System.currentTimeMillis() - start;
        System.out.println("【异步测试3】提交5个任务耗时：" + cost + "ms");
        Thread.sleep(1000);
    }
}
