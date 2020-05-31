package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.request.*;
import com.example.graduationproject.response.ShopCarResponse;
import com.example.graduationproject.response.ShopCarResponseList;
import com.example.graduationproject.service.ShopCarService;
import com.example.graduationproject.service.UserService;
import io.swagger.annotations.ApiOperation;
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
    @Autowired
    UserService userService;

    @ApiOperation("添加购物车")
    @PostMapping("add/shopCar")
    public SzpJsonResult<Integer> addShopCar(@RequestBody AddShopCarRequest addShopCarRequest){
        return SzpJsonResult.ok(shopCarService.addShopCar(addShopCarRequest));
    }

    @DeleteMapping("delete/shopCar")
    public SzpJsonResult<Integer> delShopCar(@RequestBody DeleteShopCarByIdsRequest deleteShopCarByIdsRequest){
        return SzpJsonResult.ok(shopCarService.delShopCar(deleteShopCarByIdsRequest));
    }

    @PutMapping("update/shopCar")
    public SzpJsonResult<Integer> updShopCar(@RequestBody ShopCarRequestList shopCarRequestList){
        return SzpJsonResult.ok(shopCarService.updShopCar(shopCarRequestList));
    }

    @GetMapping("select/shopCar")
    public SzpJsonResult<ShopCarResponseList> selShopCar(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "pageNumber") Integer pageNumber,@RequestParam(value = "pageSize") Integer pageSize){
        return SzpJsonResult.ok(shopCarService.selShopCar(userId,pageNumber,pageSize));
    }
}

