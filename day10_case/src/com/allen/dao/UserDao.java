package com.allen.dao;

import com.allen.domain.User;

import java.util.List;

/**
 * 用户操作的dao
 */
public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    public List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    public int add(User user);
}
