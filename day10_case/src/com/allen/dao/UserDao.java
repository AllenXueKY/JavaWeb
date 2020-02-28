package com.allen.dao;

import com.allen.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的dao
 */
public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    int add(User user);

    /**
     * 修改用户信息
     * @param user
     */
    int update(User user);

    /**
     * 根据id删除
     * @param parseInt
     */
    void delete(int parseInt);

    /**
     * 根据id查询
     * @param parseInt
     * @return
     */
    User findById(int parseInt);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
