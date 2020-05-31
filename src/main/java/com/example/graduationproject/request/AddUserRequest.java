package com.example.graduationproject.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/1/11
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AddUserRequest {

    private Long phoneNumber;

    private String password;

    private String nickName;

    private Integer age;
    //男--0      女-1
    @ApiModelProperty(value = "男--0 女-1",example = "0")
    private Short sex;

    private String imgUrl;
    @ApiModelProperty(value = "用户-0 管理员-1",example = "0")
    private Short mark=0;

    private Short vip=0;
}
