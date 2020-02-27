package com.allen.test;

import com.allen.domain.Admin;
import com.allen.service.AdminService;
import com.allen.service.impl.AdminServiceImpl;
import org.junit.Test;

public class TestLogin {
    @Test
    public void test(){
        AdminService service = new AdminServiceImpl();
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("123");
        Admin login = service.login(admin);
        System.out.println(login);
    }

    @Test
    public void testUpdateLastTime(){
        AdminService service = new AdminServiceImpl();
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("123");
        service.updateLastTime(admin);
    }

}
