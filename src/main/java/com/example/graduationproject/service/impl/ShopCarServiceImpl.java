package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.BookDao;
import com.example.graduationproject.dao.ShopCarDao;
import com.example.graduationproject.dao.UserDao;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.ShopCar;
import com.example.graduationproject.request.*;
import com.example.graduationproject.response.ShopCarResponse;
import com.example.graduationproject.response.ShopCarResponseList;
import com.example.graduationproject.service.BookService;
import com.example.graduationproject.service.ShopCarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    BookService bookService;
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;

    @Override
    public Integer addShopCar(AddShopCarRequest addShopCarRequest) {
            ShopCar shopCar = new ShopCar();
            BeanUtils.copyProperties(addShopCarRequest,shopCar);
            shopCar.setCreateTime(new Date());
            return shopCarDao.addShopCar(shopCar);
    }

    @Override
    public Integer delShopCar(DeleteShopCarByIdsRequest deleteShopCarByIdsRequest) {
        Integer result = 0;
        List<ShopCar> shopCars = shopCarDao.selectShopCarByIds(deleteShopCarByIdsRequest.getIds());
        for (ShopCar shopCar:shopCars) {
            result = shopCarDao.delShopCar(shopCar.getBookId(), shopCar.getUserId());
            result++;
        }
        if (result==deleteShopCarByIdsRequest.getIds().size()){
            return 1;    //返回当前购物车页面
        }else{
            return 0;    //返回删除失败
        }
    }

    @Override
    public Integer updShopCar(ShopCarRequestList shopCarRequestList) {
        List<ShopCarRequest> shopCarRequest1 = shopCarRequestList.getShopCarRequestList();
        Integer result = 0;
        for (ShopCarRequest shopCarRequest:shopCarRequest1) {
            ShopCar shopCar = new ShopCar();
            Book book = bookDao.selectBookByBookId(shopCarRequest.getBookId());
            BeanUtils.copyProperties(shopCarRequest,shopCar);
            shopCar.setBookId(book.getId());
            result =+ shopCarDao.updShopCar(shopCar);
            shopCar.setMount(book.getMount());
        }
        if(result==shopCarRequest1.size()){
            return 1;    //修改成功
        }else{
            return 0;    //修改失败,会滚到修改之前页面
        }
    }

    @Override
    public ShopCarResponseList selShopCar(Integer userId,Integer pageNumber,Integer size) {
        List<ShopCar> shopCarList = shopCarDao.selShopCar(userId);
        PageHelper.startPage(pageNumber,size);
        List<ShopCarResponse> shopCarResponseList = new ArrayList<>();
        for (ShopCar shopCar: shopCarList) {
            ShopCarResponse shopCarResponse = new ShopCarResponse();
            Integer bookId = shopCar.getBookId();
            Book book = bookService.selectBookById(bookId);
            shopCarResponse.setPrice(book.getPrice());
            shopCarResponse.setMount(shopCar.getMount());
            shopCarResponseList.add(shopCarResponse);
        }
        ShopCarResponseList shopCarResponseList1 = new ShopCarResponseList();
        PageInfo<ShopCarResponse> pageInfo=new PageInfo<>(shopCarResponseList);
        shopCarResponseList1.setShopCarResponseList(pageInfo.getList());
        shopCarResponseList1.setSize(pageInfo.getTotal());
        if(shopCarResponseList.size()>0){
            return shopCarResponseList1;     //查询购物车成功并返回
        }else{
            return null;                    //购物车为空，请添加意向书籍进购物车
        }
    }
}
