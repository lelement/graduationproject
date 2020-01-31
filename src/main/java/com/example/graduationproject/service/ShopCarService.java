package com.example.graduationproject.service;

import com.example.graduationproject.pojo.ShopCar;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface ShopCarService {
    Integer addShopCar(ShopCar shopCar);

    Integer delShopCar(Integer bookId);

    Integer updShopCar(ShopCar shopCar);

    List<ShopCar> selShopCar(Integer userId);
}
