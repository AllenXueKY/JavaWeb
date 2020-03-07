package com.allen.travel.service.impl;

import com.allen.travel.dao.FavorityDao;
import com.allen.travel.dao.impl.FavoriteDaoImpl;
import com.allen.travel.domain.Favorite;
import com.allen.travel.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {
    private FavorityDao favorityDao = new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favorityDao.findByRidAndUid(Integer.parseInt(rid), uid);

        return favorite != null;//如果对象有值，则为true，反之，则为false
    }

    @Override
    public void add(String rid, int uid) {
        favorityDao.add(Integer.parseInt(rid),uid);
    }
}
