package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.ShopCarMapper;
import com.example.graduationproject.pojo.ShopCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class ShopCarDao {
    @Autowired
    ShopCarMapper shopCarMapper;
    public Integer addShopCar(ShopCar shopCar) {
        return shopCarMapper.insert(shopCar);
    }

    public Integer delShopCar(Integer bookId,Integer userId) {
        Example example = new Example(ShopCar.class);
        example.createCriteria().andEqualTo("bookId",bookId)
        .andEqualTo("userId",userId);
        return shopCarMapper.deleteByExample(example);
    }

    public Integer updShopCar(ShopCar shopCar) {
        return shopCarMapper.updateByPrimaryKeySelective(shopCar);
    }

    public List<ShopCar> selShopCar(Integer userId) {
        Example example = new Example(ShopCar.class);
        example.createCriteria().andEqualTo("userId",userId);
        return shopCarMapper.selectByExample(example);
    }

    public List<ShopCar> selectShopCarByIds(List<Integer> ids) {
        Example example = new Example(ShopCar.class);
        example.createCriteria().andIn("id",ids);
        return shopCarMapper.selectByExample(example);
    }
}
