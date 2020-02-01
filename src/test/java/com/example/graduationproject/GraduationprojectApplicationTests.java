package com.example.graduationproject;

import com.example.graduationproject.mapper.OrderItemMapper;
import com.example.graduationproject.pojo.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
class GraduationprojectApplicationTests {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Test
    void contextLoads() {
        OrderItem orderItem = new OrderItem();
        orderItem.setBookId(1);
        int i = orderItemMapper.selectCount(orderItem);
        log.info("book_id的数量-{}",i);
    }

}
