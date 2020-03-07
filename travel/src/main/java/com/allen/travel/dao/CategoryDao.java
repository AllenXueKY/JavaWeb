package com.allen.travel.dao;

import com.allen.travel.domain.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();

    /**
     * 根据cid查询cname
     * @return
     */
    public String findName(int cid);
}
