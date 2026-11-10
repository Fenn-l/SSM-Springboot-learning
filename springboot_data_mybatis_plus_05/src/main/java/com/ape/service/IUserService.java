package com.ape.service;

import com.ape.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IUserService extends IService<User> {

    /**
     * 查询全部用户
     */
    List<User> findAllUser();

    /**
     * 新增单个用户
     */
    void insertUser(User user);

    /**
     * 批量新增用户（用于验证事务回滚）
     */
    void insertUsersBatch(User user1, User user2);

    /**
     * 根据 id 删除用户（逻辑删除）
     */
    void deleteUser(Long id);

    /**
     * 根据 id 修改用户（配合乐观锁）
     */
    void updateUser(User user);
}