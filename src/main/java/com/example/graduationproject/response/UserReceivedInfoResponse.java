package com.example.graduationproject.response;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/1/29
 * @Description:小冯同学写点注释吧！
 */
@Data
public class UserReceivedInfoResponse {
    Integer userId;

    String userName;

    Long phoneNumber;

    String address;

    Integer receivedInfoId;
}
