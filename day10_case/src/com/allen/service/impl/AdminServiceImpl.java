package com.allen.service.impl;

import com.allen.dao.AdminDao;
import com.allen.dao.impl.AdminDaoImpl;
import com.allen.domain.Admin;
import com.allen.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao= new AdminDaoImpl();
    @Override
    public Admin login(Admin loginAdmin) {
        return dao.login(loginAdmin);
    }

    @Override
    public void updateLastTime(Admin loginAdmin) {
        dao.updateLastTime(loginAdmin);
    }
}
