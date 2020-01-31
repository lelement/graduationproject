package com.example.graduationproject.service;

import com.example.graduationproject.pojo.ReceivedInfo;
import com.example.graduationproject.request.AddReceivedInfoRequest;
import com.example.graduationproject.response.ReceivedInfoResponse;

import java.util.List;

/**
 * Created by lemon on 2020-01-31 0:56.
 */
public interface ReceivedInfoService {
    Integer add(AddReceivedInfoRequest addReceivedInfoRequest);

    List<ReceivedInfo> selectByUserId(Integer userId);

    ReceivedInfo selectById(Integer id);

    Integer update(ReceivedInfo receivedInfo);

    Integer delete(Integer id);
}
