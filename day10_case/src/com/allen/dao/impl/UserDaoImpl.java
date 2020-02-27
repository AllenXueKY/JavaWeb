package com.allen.dao.impl;

import com.allen.dao.UserDao;
import com.allen.domain.User;
import com.allen.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //1、定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int add(User user)  {
        String sql = "insert into user values(null,?,?,?,?,?,?)";
        int count = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return count;
    }

    /**
     * 修改用户信息
     * @param user 修改后对象
     * @return 影响的行数
     */
    @Override
    public int update(User user) {
        String sql = "update user set gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
        int count = template.update(sql, user.getGender(), user.getAge(),user.getAddress(), user.getQq(), user.getEmail(),user.getId());
        return count;
    }
}
