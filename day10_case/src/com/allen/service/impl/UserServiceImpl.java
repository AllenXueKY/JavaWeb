package com.allen.service.impl;

import com.allen.dao.UserDao;
import com.allen.dao.impl.UserDaoImpl;
import com.allen.domain.User;
import com.allen.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public int add(User user) {
        return dao.add(user);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

}
