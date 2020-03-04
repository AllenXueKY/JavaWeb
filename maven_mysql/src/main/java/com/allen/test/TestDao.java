package com.allen.test;

import com.allen.domain.User;
import com.allen.service.UserService;
import com.allen.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestDao {

    @Test
    public void test(){
        UserService service = new UserServiceImpl();
        List<User> list = service.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
