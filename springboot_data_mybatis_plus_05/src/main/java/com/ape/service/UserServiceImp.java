package com.ape.service;

import com.ape.mapper.UserMapper;
import com.ape.pojo.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * MP 3.5.7 起 IService 新增了 getBaseMapper() / getEntityClass() 两个抽象方法。
 * 推荐做法：继承 ServiceImpl<M, T>，由框架自动提供这两个方法的实现，
 * 同时还能直接使用 IService 自带的全套 CRUD。
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 查询全部用户
     */
    @Override
    public List<User> findAllUser() {
        return this.getBaseMapper().findAllUser();
    }

    /**
     * 事务演示：新增单个用户
     */
    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public void insertUser(User user) {
        this.getBaseMapper().insert(user);
    }

    /**
     * 批量新增：用于验证事务的整体性与回滚
     * 插入过程中模拟抛出异常，观察前面已插入的数据是否被回滚
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUsersBatch(User user1, User user2) {
        //插入第一条，正常
        this.getBaseMapper().insert(user1);
        //插入第二条，此处人为制造异常，触发事务回滚
        this.getBaseMapper().insert(user2);
        throw new RuntimeException("模拟异常：事务应当整体回滚");
    }

    /**
     * 逻辑删除演示：删除后数据仍保留在库中（deleted 字段置为 1）
     */
    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public void deleteUser(Long id) {
        this.getBaseMapper().deleteById(id);
    }

    /**
     * 乐观锁演示：先查询再修改，version 由 MP 自动 +1
     */
    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public void updateUser(User user) {
        this.getBaseMapper().updateById(user);
    }
}