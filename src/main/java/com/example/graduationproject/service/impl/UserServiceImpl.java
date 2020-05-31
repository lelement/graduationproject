package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.UserDao;
import com.example.graduationproject.pojo.User;
import com.example.graduationproject.request.AddUserRequest;
import com.example.graduationproject.request.UpdateUserRequest;
import com.example.graduationproject.response.LoginResponse;
import com.example.graduationproject.response.UserResponse;
import com.example.graduationproject.response.UserResponseList;
import com.example.graduationproject.service.UserService;
import com.example.graduationproject.utils.DateTimeUtil;
import com.example.graduationproject.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Slf4j
@Service
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Integer exist(Long phoneNumber) {
        return userDao.exist(phoneNumber).size();
    }

    @Override
    public Integer addUser(AddUserRequest addUserRequest) {
        User user = new User();
        BeanUtils.copyProperties(addUserRequest, user);
        user.setCreateTime(new Date());
        return userDao.addUser(user);
    }

    @Override
    public Integer delUser(Integer id) {
        return userDao.delUser(id);
    }

    @Override
    public Integer updUser(UpdateUserRequest updateUserRequest) {
        User user = new User();
        BeanUtils.copyProperties(updateUserRequest,user);
        return userDao.updUser(user);
    }

    @Override
    public LoginResponse login(Long usernumber, String password) {
        LoginResponse loginResponse = new LoginResponse();
        List<User> list = userDao.login(usernumber, password);
        if (!CollectionUtils.isEmpty(list)) {
            User user = list.get(0);
            loginResponse.setUser(user);
            String uuid = UUID.randomUUID().toString();
            String token = uuid + "," + user.getId() + "," + user.getNickName() + "," + user.getPhoneNumber();
            log.info("该用户-{},token-{}", user.toString(), token);
            //将token留在redis中
            stringRedisTemplate.opsForValue().set(token, JsonUtils.objectToJson(user));
            stringRedisTemplate.expire(token, 10, TimeUnit.DAYS);
            loginResponse.setToken(token);
        }
        return loginResponse;
    }

    //只有mark为1时，提供此方法
    @Override
    public  UserResponseList selUser(Short mark,Integer pageNumber,Integer size){
        PageHelper.startPage(pageNumber,size);
         List<User> userList = userDao.selectAll(mark);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        UserResponseList userResponseList = new UserResponseList();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user:pageInfo.getList()){
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user,userResponse);
            userResponse.setCreateTime(DateTimeUtil.getDateTimeToString(user.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            userResponses.add(userResponse);
        }
        userResponseList.setList(userResponses);
        userResponseList.setTotal(pageInfo.getTotal());
        return userResponseList;
    }

    @Override
    public User selUser(Integer userID) {
        return userDao.getUserById(userID);
    }

    @Override
    public UserResponseList sellectAllUser(Integer pageNumber, Integer pageSize) {
        UserResponseList userResponseList = new UserResponseList();
        PageHelper.startPage(pageNumber,pageSize);
        List<User> userList = userDao.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user:pageInfo.getList()){
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user,userResponse);
            userResponse.setCreateTime(DateTimeUtil.getDateTimeToString(user.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            userResponses.add(userResponse);
        }
        userResponseList.setList(userResponses);
        userResponseList.setTotal(pageInfo.getTotal());
        return userResponseList;
    }

    @Override
    public UserResponseList selectUserByKeyword(String keyword, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        UserResponseList userResponseList = new UserResponseList();
        List<User> userList = null;
        if (!StringUtils.isEmpty(keyword)) {
            userList = userDao.selectUserByKeyword(keyword);
        }else {
            userList = userDao.selectAllUser();
        }
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user:pageInfo.getList()){
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user,userResponse);
            userResponse.setCreateTime(DateTimeUtil.getDateTimeToString(user.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            userResponses.add(userResponse);
        }
        userResponseList.setList(userResponses);
        userResponseList.setTotal(pageInfo.getTotal());
        return userResponseList;
    }

    @Override
    public UserResponse getUserById(Integer userId) {
        UserResponse userResponse = new UserResponse();
        User user = userDao.getUserById(userId);
        userResponse.setCreateTime(DateTimeUtil.getDateTimeToString(user.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
        BeanUtils.copyProperties(user,userResponse);
        return userResponse;
    }

}
