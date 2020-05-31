package com.example.graduationproject.request;

import lombok.Data;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/15
 * @Description:小冯同学写点注释吧！
 */
@Data
public class DeleteShopCarByIdsRequest {
    private List<Integer> ids;
}
