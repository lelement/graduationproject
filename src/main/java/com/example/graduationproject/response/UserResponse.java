package com.example.graduationproject.response;

import com.example.graduationproject.pojo.User;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;


/**
 * @Author:Fengxutong
 * @Date:2020/2/7
 * @Description:小冯同学写点注释吧！
 */
@Data
public class UserResponse {
    private Integer id;

    private Long phoneNumber;

    private String password;

    private String nickName;


    private String createTime;

    private Integer age;

    /**
     * 男--0      女-1
     */
    private Short sex;

    /**
     * 非会员-0 会员-1

     */
    private Short vip;

    private String imgUrl;

    /**
     * 用户-0    管理员-1
     */
    private Short mark;

    private Date endTime;

}
