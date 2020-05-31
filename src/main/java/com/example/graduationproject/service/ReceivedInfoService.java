package com.example.graduationproject.service;

import com.example.graduationproject.pojo.ReceivedInfo;
import com.example.graduationproject.request.AddReceivedInfoRequest;
import com.example.graduationproject.request.DeleteReceivedInfoRequest;
import com.example.graduationproject.request.SelectReceivedInfoRequest;
import com.example.graduationproject.request.UpdateReceivedInfoRequest;
import com.example.graduationproject.response.ReceivedInfoResponseList;

/**
 * Created by lemon on 2020-01-31 0:56.
 */
public interface ReceivedInfoService {
    Integer add(AddReceivedInfoRequest addReceivedInfoRequest);

    ReceivedInfo selectById(Integer id);

    Integer update(UpdateReceivedInfoRequest updateReceivedInfoRequest);

    Integer delete(DeleteReceivedInfoRequest deleteReceivedInfoRequest);

    ReceivedInfoResponseList selectByUserId(Integer userId,Integer pageNumber,Integer size);
}
