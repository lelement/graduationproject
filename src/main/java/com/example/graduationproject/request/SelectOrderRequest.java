package com.example.graduationproject.request;

import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/2/13
 * @Description:小冯同学写点注释吧！
 */
@Data
public class SelectOrderRequest {
    private Integer userId;

    private Short orderState;

    private Integer pageNumber=1;

    private Integer pageSize=10;

}
