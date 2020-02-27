package com.allen.service;

import com.allen.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    public int add(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int update(User user);
}
