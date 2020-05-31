package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.ReceivedInfoDao;
import com.example.graduationproject.pojo.ReceivedInfo;
import com.example.graduationproject.request.AddReceivedInfoRequest;
import com.example.graduationproject.request.DeleteReceivedInfoRequest;
import com.example.graduationproject.request.SelectReceivedInfoRequest;
import com.example.graduationproject.request.UpdateReceivedInfoRequest;
import com.example.graduationproject.response.ReceivedInfoResponseList;
import com.example.graduationproject.service.ReceivedInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Integer delete(DeleteReceivedInfoRequest deleteReceivedInfoRequest) {
        return receivedInfoDao.delete(deleteReceivedInfoRequest.getId());
    }

    @Override
    public Integer update(UpdateReceivedInfoRequest updateReceivedInfoRequest) {
        ReceivedInfo receivedInfo = new ReceivedInfo();
        BeanUtils.copyProperties(updateReceivedInfoRequest,receivedInfo);
        return receivedInfoDao.update(receivedInfo);
    }

    @Override
    public ReceivedInfo selectById(Integer id) {
        return receivedInfoDao.selectById(id);
    }

    @Override
    public ReceivedInfoResponseList selectByUserId(Integer userId,Integer pageNumber,Integer size) {
        List<ReceivedInfo> receivedInfos = receivedInfoDao.selectByUserId(userId);
        PageHelper.startPage(pageNumber,size);
        ReceivedInfoResponseList list = new ReceivedInfoResponseList();
        PageInfo<ReceivedInfo> pageInfo = new PageInfo<>(receivedInfos);
        list.setList(pageInfo.getList());
        list.setTotal(pageInfo.getTotal());
        return list;
    }
}
