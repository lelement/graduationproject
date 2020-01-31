package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.ShopCar;
import com.example.graduationproject.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;

    @PostMapping("add/shopCar/by/json")
    public Integer addShopCar(ShopCar shopCar){
        return shopCarService.addShopCar(shopCar);
    }

    @DeleteMapping("delete/shopCar/by/json")
    public Integer delShopCar(Integer bookId){
        return shopCarService.delShopCar(bookId);
    }

    @PutMapping("update/shopCar/by/json")
    public Integer updShopCar(ShopCar shopCar){
        return shopCarService.updShopCar(shopCar);
    }

    @GetMapping("select/shopCar/by/json")
    public SzpJsonResult<ShopCar> selShopCar(Integer userId){
        return SzpJsonResult.ok(shopCarService.selShopCar(userId));
    }
}
