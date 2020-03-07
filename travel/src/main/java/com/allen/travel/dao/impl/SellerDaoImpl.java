package com.allen.travel.dao.impl;

import com.allen.travel.dao.SellerDao;
import com.allen.travel.domain.Seller;
import com.allen.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Seller findById(int sid) {
        String sql = "select * from tab_seller where sid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Seller>(Seller.class),sid);
    }
}
