package com.example.graduationproject.request;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.ReceivedInfo;
import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/1/11
 * @Description:小冯同学写点注释吧！
 */
@Data
public class OrderRequest {
    private Integer id;

    private Integer userId;

    //更新状态码
    private Short orderState;

    private Integer bookId;

    private Integer bookMount;

    private Double totalPrice;

    private Integer receivedInfoId;
}
