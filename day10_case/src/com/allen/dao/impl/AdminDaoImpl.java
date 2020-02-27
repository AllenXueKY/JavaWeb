package com.allen.dao.impl;

import com.allen.dao.AdminDao;
import com.allen.domain.Admin;
import com.allen.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录查询
     * @param loginAdmin 只有用户名和密码
     * @return 包含管理员全部数据，没有查询到，返回null
     */
    @Override
    public Admin login(Admin loginAdmin) {
        try {
            String sql = "select * from admin where username = ? and password = ?";
            Admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), loginAdmin.getUsername(), loginAdmin.getPassword());
            return admin;
        }catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }

    /**
     * 登录后将时间上传
     * @param loginAdmin
     */
    @Override
    public void updateLastTime(Admin loginAdmin) {
        //获取时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_date = sdf.format(new Date());
        String sql = "update admin set lastTime = ? where username = ? and password = ?";
        template.update(sql,str_date,loginAdmin.getUsername(),loginAdmin.getPassword());
    }

}
