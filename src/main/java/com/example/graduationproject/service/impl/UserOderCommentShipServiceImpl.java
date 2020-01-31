package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.UserOrderCommentShipDao;
import com.example.graduationproject.pojo.UserOrderCommentShip;
import com.example.graduationproject.service.UserOrderCommentShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Service
public class UserOderCommentShipServiceImpl implements UserOrderCommentShipService {

    @Autowired
    UserOrderCommentShipDao userOrderCommentShipDao;
    @Override
    public Integer addUOCShip(UserOrderCommentShip userOrderCommentShip) {
        return userOrderCommentShipDao.addUserOrderCommentShip(userOrderCommentShip);
    }

    @Override
    public Integer delUOCShip(Integer commentId) {
        return null;
    }
}
