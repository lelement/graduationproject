package com.example.graduationproject.request;

import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/2/1
 * @Description:小冯同学写点注释吧！
 */
@Data
public class ReceivedInfoRequest {
    private Integer id;

    private String name;

    private Long phoneNumber;

    private String address;
}
