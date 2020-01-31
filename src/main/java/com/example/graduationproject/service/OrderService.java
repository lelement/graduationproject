package com.example.graduationproject.service;

import com.example.graduationproject.request.OrderRequest;
import com.example.graduationproject.response.OrderResponse;

import java.util.List;

/**
 * Created by lemon on 2020-01-30 20:07.
 */
public interface OrderService {
    List<OrderResponse> selectAll(Integer pageNumber, Integer pageSize);

    Integer updateOrder(OrderRequest orderRequest);

    Integer deleteOrderById(Integer orderId);

    OrderResponse selectByOrderId(Integer orderId);
}
