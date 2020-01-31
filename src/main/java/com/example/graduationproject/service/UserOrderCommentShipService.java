package com.example.graduationproject.service;

import com.example.graduationproject.pojo.UserOrderCommentShip;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface UserOrderCommentShipService {
    Integer addUOCShip(UserOrderCommentShip userOrderCommentShip);

    Integer delUOCShip(Integer commentId);
}
