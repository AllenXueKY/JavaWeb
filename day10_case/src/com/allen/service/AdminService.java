package com.allen.service;

import com.allen.domain.Admin;

public interface AdminService {
    /**
     * 登录查询管理员信息
     * @param loginAdmin
     * @return
     */
    public Admin login(Admin loginAdmin);

    public void updateLastTime(Admin loginAdmin);
}
