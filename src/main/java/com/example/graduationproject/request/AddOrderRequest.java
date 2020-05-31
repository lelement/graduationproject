package com.example.graduationproject.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @Author:Fengxutong
 * @Date:2020/1/29
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AddOrderRequest {
    private Integer userId;

    private Integer bookId;
    @ApiModelProperty(value = "要买几本书",example = "1")
    private Integer bookMount;

    private Integer receivedInfoId=1;
    @ApiModelProperty(value = "0:未付款 1:已付款未发货  2:已发货  3:已收货",example = "0")
    private Short orderState = 0;

    private Double totalPrice;

}
