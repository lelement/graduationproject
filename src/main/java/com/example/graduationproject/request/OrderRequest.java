package com.example.graduationproject.request;

import com.example.graduationproject.pojo.ReceivedInfo;
import lombok.Data;


/**
 * @Author:Fengxutong
 * @Date:2020/1/11
 * @Description:小冯同学写点注释吧！
 */
@Data
public class OrderRequest {
    //根据id修改得传id
    private Integer id;
    //可以用来验证用户的合法性，也可以不用，先留着
    private Integer userId;
    //更新状态码
    private Short orderState;
    //下单先不买，完了充值vip,再去付钱
    private Double totalPrice;
    //确认信息可以修改收货地址
    private Integer receivedInfoId;

}
