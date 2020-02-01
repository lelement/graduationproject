package com.example.graduationproject.mapper;

import com.example.graduationproject.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderItemMapper extends CommonMapper<OrderItem> {
}