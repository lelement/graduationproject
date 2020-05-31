package com.example.graduationproject.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-25 22:49.
 */
@Data
public class UpdateUserRequest {
    private Integer id;

    private String usernumber;

    private String password;

    private String nickName;

    private Integer age;

    private Short sex;

    private Short isvip;

    private String imgUrl;

    /**
     * 用户-0    管理员-1
     */
    private Short mark;

}
