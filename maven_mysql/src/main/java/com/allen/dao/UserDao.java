package com.allen.dao;

import com.allen.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
}
