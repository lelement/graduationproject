package com.example.graduationproject.service;

import com.example.graduationproject.request.AddShopCarRequest;
import com.example.graduationproject.request.DeleteShopCarByIdsRequest;
import com.example.graduationproject.request.SelectShopCarByUserIdRequest;
import com.example.graduationproject.request.ShopCarRequestList;
import com.example.graduationproject.response.ShopCarResponseList;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface ShopCarService {
    Integer addShopCar(AddShopCarRequest shopCar);

    Integer delShopCar(DeleteShopCarByIdsRequest deleteShopCarByIdsRequest);

    Integer updShopCar(ShopCarRequestList shopCarRequestList);

    ShopCarResponseList selShopCar(Integer userId,Integer pageNumber,Integer size);

}
