package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.ReceivedInfoDao;
import com.example.graduationproject.pojo.ReceivedInfo;
import com.example.graduationproject.request.AddReceivedInfoRequest;
import com.example.graduationproject.response.ReceivedInfoResponse;
import com.example.graduationproject.service.ReceivedInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lemon on 2020-01-31 0:56.
 */
@Service
public class ReceivedInfoServiceImpl implements ReceivedInfoService {
    @Autowired
    private ReceivedInfoDao receivedInfoDao;

    @Override
    public Integer add(AddReceivedInfoRequest addReceivedInfoRequest) {
        ReceivedInfo receivedInfo = new ReceivedInfo();
        BeanUtils.copyProperties(addReceivedInfoRequest,receivedInfo);
        return receivedInfoDao.add(receivedInfo);
    }

    @Override
    public List<ReceivedInfo> selectByUserId(Integer userId) {
        return receivedInfoDao.selectByUserId(userId);
    }

    @Override
    public ReceivedInfo selectById(Integer id) {
        return receivedInfoDao.selectById(id);
    }

    @Override
    public Integer update(ReceivedInfo receivedInfo) {
        return receivedInfoDao.update(receivedInfo);
    }

    @Override
    public Integer delete(Integer id) {
        return receivedInfoDao.delete(id);
    }
}
