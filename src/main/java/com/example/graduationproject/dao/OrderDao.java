package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.OrderMapper;
import com.example.graduationproject.pojo.Order;
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
public class OrderDao {
    @Autowired
    OrderMapper orderMapper;
    public Integer addOrder(Order order) {
        return orderMapper.insert(order);
    }

    public Integer delOrder(Integer bookId) {
        Example example = new Example(Order.class);
        example.createCriteria().andEqualTo("bookId",bookId);
        return orderMapper.deleteByExample(example);
    }

    public Integer deleteOrderById(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    public Integer updOrder(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    public List<Order> selOrder(Integer userId) {
        Example example = new Example(Order.class);
        example.createCriteria().andEqualTo("userId",userId);
        return orderMapper.selectByExample(example);
    }

    public List<Order> selUserReceivedInfoByUserId(Integer userId) {
        Example example = new Example(Order.class);
        example.createCriteria().andEqualTo("userId",userId);
        return orderMapper.selectByExample(example);
    }

    public  List<Order> selectAll(Short orderState){
        Example example = new Example(Order.class);
        example.createCriteria().andEqualTo("orderState",orderState);
        return orderMapper.selectByExample(example);
    }

    public List<Order> getOrderByUserIdAndStatus(Integer userId, Short orderState) {
        Example example = new Example(Order.class);
        example.createCriteria().andEqualTo("userId",userId).andEqualTo("orderState",orderState);
        return orderMapper.selectByExample(example);
    }

    public List<Order> selectAllOrders() {
        return orderMapper.selectAll();
    }
}
