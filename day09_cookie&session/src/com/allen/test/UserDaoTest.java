package com.allen.test;

import com.allen.dao.UserDao;
import com.allen.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
