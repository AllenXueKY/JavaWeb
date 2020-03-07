package com.allen.travel.dao.impl;

import com.allen.travel.dao.CategoryDao;
import com.allen.travel.domain.Category;
import com.allen.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category";
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }

    @Override
    public String findName(int cid) {
        String sql = "select * from tab_category where cid = ?";
        Category c = template.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class), cid);
        return c.getCname();
    }

}
