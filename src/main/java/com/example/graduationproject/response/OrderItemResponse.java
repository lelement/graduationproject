package com.example.graduationproject.response;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.pojo.OrderItem;
import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-01-30 16:16.
 */
@Data
public class OrderItemResponse extends OrderItem {
    private Book book;


}
