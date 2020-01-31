package com.example.graduationproject.request;

import lombok.Data;

/**
 * Created by lemon on 2020-01-29 15:22.
 */
@Data
public class ReceivedInfoRequest {
    private Integer id;

    private String name;

    private Long phone;

    private String address;

}
