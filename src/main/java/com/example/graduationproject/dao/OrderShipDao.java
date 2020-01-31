package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.OrderShipMapper;
import com.example.graduationproject.pojo.OrderItem;
import com.example.graduationproject.pojo.OrderShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lemon on 2020-01-30 20:05.
 */
@Repository
public class OrderShipDao {
    @Autowired
    private OrderShipMapper orderShipMapper;

    public List<OrderShip> selectOrderItemIdByOrderId(Integer orderId) {
        Example example = new Example(OrderShip.class);
        example.createCriteria()
                .andEqualTo("orderId",orderId);
        return orderShipMapper.selectByExample(example);
    }

    public Integer deleteOrderShipByIds(List<Integer> orderShipIds) {
        Example example = new Example(OrderShip.class);
        example.createCriteria()
                .andIn("id",orderShipIds);
        return orderShipMapper.deleteByExample(example);
    }
}
