package com.example.graduationproject.response;

import lombok.Data;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/13
 * @Description:小冯同学写点注释吧！
 */
@Data
public class ShopCarResponseList {
    private List<ShopCarResponse> shopCarResponseList;
    private Long size;
}
