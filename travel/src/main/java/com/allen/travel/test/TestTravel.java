package com.allen.travel.test;

import com.allen.travel.dao.UserDao;
import com.allen.travel.dao.impl.UserDaoImpl;
import com.allen.travel.domain.User;
import com.allen.travel.service.UserService;
import com.allen.travel.service.impl.UserServiceImpl;
import org.junit.Test;

public class TestTravel {
    @Test
    public void test1(){
        UserDao dao = new UserDaoImpl();
        User xky = dao.findByUserName("superbaby");
        System.out.println(xky);
    }
}
