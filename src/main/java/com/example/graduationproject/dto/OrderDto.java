package com.example.graduationproject.dto;

import com.example.graduationproject.pojo.Order;
import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-26 0:21.
 */
@Data
public class OrderDto extends Order {
    private String expressNum;
}
