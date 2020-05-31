package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.dto.OrderDto;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.request.*;
import com.example.graduationproject.response.OrderResponse;
import com.example.graduationproject.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @ApiOperation("添加订单")
    @PostMapping("post/order")
    public SzpJsonResult<Integer> addOrder(@RequestBody AddOrderRequest addOrderRequest){
        return SzpJsonResult.ok(orderService.addOrder(addOrderRequest));
    }

    @DeleteMapping("delete/order")
    public SzpJsonResult<Integer> delOrder(@PathVariable(value="userId") Integer orderId){
        return SzpJsonResult.ok(orderService.deleteOrderById(orderId));
    }
    @ApiOperation("更新订单")
    @PutMapping("update/order")
    public SzpJsonResult<Integer> updOrder(@RequestBody OrderDto order){
        return SzpJsonResult.ok(orderService.updOrderItem(order));
    }

    /**
     * 用户查看不同支付状态的订单
     * @param userId
     * @param orderState
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @ApiOperation("用户查看不同支付状态的订单")
    @GetMapping("get/order/by/orderState")
    public SzpJsonResult<OrderResponseList> selOrder(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "orderState") Short orderState,@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return SzpJsonResult.ok(orderService.selOrder(userId,orderState,pageNumber,pageSize));
    }

    /**
     * 用户查看所有订单
     * @param userId
     * @return
     */
    @ApiOperation("用户查看所有订单")
    @GetMapping("get/order/by/userId")
    public SzpJsonResult<OrderResponseList> selUserReceivedInfoByUserId(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize) {
        return SzpJsonResult.ok(orderService.selUserReceivedInfoByUserId(userId,pageNumber,pageSize));
    }

    @ApiOperation("管理员根据订单状态查看所有相关订单")
    @GetMapping("get/order/status")
    public SzpJsonResult<OrderResponseList> selectAll(@RequestParam(value = "orderState") Short orderState,@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return SzpJsonResult.ok(orderService.selectAll(orderState,pageNumber,pageSize));
    }

    @ApiOperation("查看所有订单")
    @GetMapping("get/all/order")
    public SzpJsonResult<OrderResponseList> getAllOrders(@RequestParam(value = "orderState",defaultValue = "100")Short orderState,@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return SzpJsonResult.ok(orderService.selectAllOrders(orderState,pageNumber,pageSize));
    }

    @ApiOperation("取消订单")
    @PutMapping("cancle/order")
    public SzpJsonResult<Integer> cancleOrder(@RequestBody @ApiParam(value = "需要订单id，书籍id，购买数量") CancleOrderReuquest cancleOrderReuquest){
        return SzpJsonResult.ok(orderService.cancleOrder(cancleOrderReuquest));
    }
}
