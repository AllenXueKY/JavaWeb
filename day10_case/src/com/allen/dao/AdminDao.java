package com.allen.dao;

import com.allen.domain.Admin;

import java.util.Date;

public interface AdminDao {
    /**
     * 登录
     */
    public Admin login(Admin loginAdmin);

    /**
     * 登录后将时间上传
     * @param loginAdmin
     */
    public void updateLastTime(Admin loginAdmin);
}
