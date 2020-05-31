package com.example.graduationproject.response;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.pojo.ReceivedInfo;
import com.example.graduationproject.pojo.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lemon on 2020-01-30 16:11.
 */
@Data
public class OrderResponse {
    private Integer id;

    private Integer userId;

    private Integer receivedInfoId;

    private Integer bookId;

    private Integer bookMount;

    private Short orderState;

    private Double totalPrice;

    private Date createTime;

    private Book book;

    private ReceivedInfo receivedInfo;

    private User user;
    @ApiModelProperty(value = "订单号")
    private String expressNum;


}
