package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.request.OrderRequest;
import com.example.graduationproject.response.OrderResponse;
import com.example.graduationproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lemon on 2020-01-30 20:04.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping(value = "select/all/order")
    public SzpJsonResult<OrderResponse> selectAllOrders(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        return SzpJsonResult.ok(orderService.selectAll(pageNumber, pageSize));
    }

    @PutMapping(value = "update/order/state")
    public SzpJsonResult<Integer> updateOrderById(@RequestBody OrderRequest orderRequest) {
        return SzpJsonResult.ok(orderService.updateOrder(orderRequest));
    }

    @GetMapping(value = "find/order/by/id")
    public SzpJsonResult<OrderResponse> findOrderResponseByOrderId(@RequestParam(value = "orderId") Integer orderId){
        return SzpJsonResult.ok(orderService.selectByOrderId(orderId));
    }

}
