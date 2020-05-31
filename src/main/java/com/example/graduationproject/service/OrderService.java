package com.example.graduationproject.service;

import com.example.graduationproject.dto.OrderDto;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.request.*;
import com.example.graduationproject.response.OrderResponse;
import io.swagger.models.auth.In;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface OrderService {
    Integer addOrder(AddOrderRequest addOrderRequest);

    Integer deleteOrderById(Integer orderId);

    Integer updOrderItem(OrderDto order);

    OrderResponseList selOrder(Integer userId,Short orderState,Integer pageNumber,Integer pageSize);

    OrderResponseList selUserReceivedInfoByUserId(Integer userId,Integer pageNumber,Integer pageSize);

    OrderResponseList selectAllOrders(Short orderState,Integer pageNumber,Integer pageSize);

    OrderResponseList selectAll(Short orderState,Integer pageNumber,Integer pageSize);

    Integer cancleOrder(CancleOrderReuquest cancleOrderReuquest);
}
