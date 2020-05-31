package com.example.graduationproject.response;

import com.example.graduationproject.pojo.User;
import lombok.Data;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/11
 * @Description:小冯同学写点注释吧！
 */
@Data
public class UserResponseList {
    private List<UserResponse> list;
    private Long total;
}
