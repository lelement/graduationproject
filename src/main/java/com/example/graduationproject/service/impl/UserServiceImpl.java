package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.UserDao;
import com.example.graduationproject.pojo.User;
import com.example.graduationproject.request.AddUserRequest;
import com.example.graduationproject.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public boolean exists(Long phone) {
        User user = new User();
        user.setPhoneNumber(phone);
        List<User> list=userDao.select(user);
        return list!=null&&list.size()==1;
    }

    @Override
    public List<User> selectAll(Integer pageSize, Integer pageNumber,Integer mark) {
        PageHelper.startPage(pageNumber,pageSize);
        List<User> list = userDao.selectAll(mark);
        PageInfo<User> users = new PageInfo<>(list);
        return users.getList();
    }

    @Override
    public Integer addUser(AddUserRequest addUserRequest) {
        if (!exists(addUserRequest.getPhoneNumber())) {
            User user = new User();
            BeanUtils.copyProperties(addUserRequest, user);
            user.setCreateTime(new Date());
            user.setMark((short)0);
            return userDao.addUser(user);
        }else {
            return 0;
        }
    }

    @Override
    public Integer addAdmin(AddUserRequest addUserRequest) {
        if (!exists(addUserRequest.getPhoneNumber())) {
            User user = new User();
            BeanUtils.copyProperties(addUserRequest, user);
            user.setCreateTime(new Date());
            user.setMark((short)1);
            return userDao.addUser(user);
        }else {
            return 0;
        }
    }

    @Override
    public Integer deleteById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public Integer deleteByIds(List<Integer> ids) {
        return userDao.deleteUserByIds(ids);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Integer updateAdmin(User user) {
        user.setMark((short)1);
        return userDao.updateUser(user);
    }
}
