package com.allen.service.impl;

import com.allen.dao.UserDao;
import com.allen.dao.impl.UserDaoImpl;
import com.allen.domain.User;
import com.allen.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    public List<User> findAll() {
        return dao.findAll();
    }
}
