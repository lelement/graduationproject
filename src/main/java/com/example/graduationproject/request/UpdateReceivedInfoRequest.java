package com.example.graduationproject.request;

import com.example.graduationproject.pojo.ReceivedInfo;
import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/2/14
 * @Description:小冯同学写点注释吧！
 */
@Data
public class UpdateReceivedInfoRequest {
    private Integer id;

    private Integer userId;

    private String name;

    private Long phoneNumber;

    private String address;

    /**
     *1-默认地址  0-普通地址
     */
    private Short mark;
}
