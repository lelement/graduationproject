package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.OrderMapper;
import com.example.graduationproject.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class OrderDao {
    @Autowired
    OrderMapper orderMapper;


    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    public Integer updateOrder(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    public Integer deleteOrderById(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    public Order selectById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
