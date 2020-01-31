package com.example.graduationproject.response;

import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.pojo.ReceivedInfo;
import com.example.graduationproject.pojo.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lemon on 2020-01-30 16:11.
 */
@Data
public class OrderResponse extends Order {
    private User user;

    private ReceivedInfoResponse receivedInfo;

    private List<OrderItemResponse> list = new ArrayList<>();

    public List<OrderItemResponse> getList() {
        return list;
    }

    public void setList(List<OrderItemResponse> list) {
        this.list = list;
    }

    public void add(OrderItemResponse orderItemResponse) {
        this.list.add(orderItemResponse);
    }
}
