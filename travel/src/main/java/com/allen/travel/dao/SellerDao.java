package com.allen.travel.dao;

import com.allen.travel.domain.Seller;

public interface SellerDao {
    /**
     * 根据sid查询商家信息
     * @param sid
     * @return
     */
    public Seller findById(int sid);
}
