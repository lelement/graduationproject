package com.example.graduationproject.request;

import lombok.Data;

/**
 * Created by lemon on 2020-01-31 0:58.
 */
@Data
public class AddReceivedInfoRequest {
    private Integer userId;

    private String name;

    private Long phone;

    private String address;
    /**
     * 1-为默认地址 0-普通地址
     */
    private Short mark;
}
