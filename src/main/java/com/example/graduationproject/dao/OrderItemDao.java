package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.OrderItemMapper;
import com.example.graduationproject.pojo.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lemon on 2020-01-30 20:05.
 */
@Repository
public class OrderItemDao {
    @Autowired
    private OrderItemMapper orderItemMapper;
    public List<OrderItem> selectOrderItemByOrderItemId(Integer orderItemId) {
        Example example = new Example(OrderItem.class);
        example.createCriteria()
                .andEqualTo("id",orderItemId);
        return orderItemMapper.selectByExample(example);
    }

    public Integer deleteOrderItemByIds(List<Integer> orderItemIds) {
        Example example = new Example(OrderItem.class);
        example.createCriteria()
                .andEqualTo("id",orderItemIds);
        return orderItemMapper.deleteByExample(example);
    }

    public List<OrderItem> selectsellBookNumber(Integer bookId) {
        Example example = new Example(OrderItem.class);
        example.createCriteria()
                .andEqualTo("bookId",bookId);
        return orderItemMapper.selectByExample(example);
    }
}
