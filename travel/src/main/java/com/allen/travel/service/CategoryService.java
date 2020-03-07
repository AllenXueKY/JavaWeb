package com.allen.travel.service;

import com.allen.travel.domain.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();

    /**
     * 根据cid查询cname
     * @param cid
     * @return
     */
    public String findName(int cid);
}
