package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.ShopCarDao;
import com.example.graduationproject.pojo.ShopCar;
import com.example.graduationproject.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Service
public class ShopCarServiceImpl implements ShopCarService {
    @Autowired
    ShopCarDao shopCarDao;
    @Override
    public Integer addShopCar(ShopCar shopCar) {
        return shopCarDao.addShopCar(shopCar);
    }

    @Override
    public Integer delShopCar(Integer bookId) {
        return shopCarDao.delShopCar(bookId);
    }

    @Override
    public Integer updShopCar(ShopCar shopCar) {
        return shopCarDao.updShopCar(shopCar);
    }

    @Override
    public List<ShopCar> selShopCar(Integer userId) {
        return shopCarDao.selShopCar(userId);
    }
}
