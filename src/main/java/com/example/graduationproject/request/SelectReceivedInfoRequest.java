package com.example.graduationproject.request;

import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/2/16
 * @Description:小冯同学写点注释吧！
 */
@Data
public class SelectReceivedInfoRequest {
    private Integer userId;

    private Integer pageNumber;

    private Integer size;
}
