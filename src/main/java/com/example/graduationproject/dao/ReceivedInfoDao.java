package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.ReceivedInfoMapper;
import com.example.graduationproject.pojo.ReceivedInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lemon on 2020-01-30 20:06.
 */
@Repository
public class ReceivedInfoDao {
    @Autowired
    ReceivedInfoMapper receivedInfoMapper;

    public List<ReceivedInfo> selectByUserId(Integer userId) {
        Example example = new Example(ReceivedInfo.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return receivedInfoMapper.selectByExample(example);
    }

    public ReceivedInfo selectById(Integer receivedInfoId) {
        return receivedInfoMapper.selectByPrimaryKey(receivedInfoId);
    }

    public Integer add(ReceivedInfo receivedInfo) {
        return receivedInfoMapper.insert(receivedInfo);
    }

    public Integer update(ReceivedInfo receivedInfo) {
        return receivedInfoMapper.updateByPrimaryKeySelective(receivedInfo);
    }

    public Integer delete(Integer id) {
        return receivedInfoMapper.deleteByPrimaryKey(id);
    }
}
