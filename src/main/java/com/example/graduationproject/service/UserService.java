package com.example.graduationproject.service;

import com.example.graduationproject.pojo.User;
import com.example.graduationproject.request.AddUserRequest;
import com.example.graduationproject.request.UpdateUserRequest;
import com.example.graduationproject.response.LoginResponse;
import com.example.graduationproject.response.UserResponse;
import com.example.graduationproject.response.UserResponseList;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface UserService {
    Integer exist(Long phoneNumber);

    Integer addUser(AddUserRequest addUserRequest);

    Integer delUser(Integer id);

    Integer updUser(UpdateUserRequest user);

    LoginResponse login(Long usernumber, String password);

    UserResponseList selUser(Short mark,Integer pageNumber,Integer size);

    User selUser(Integer userID);

    UserResponseList sellectAllUser(Integer pageNumber, Integer pageSize);

    UserResponseList selectUserByKeyword(String keyword, Integer pageNumber, Integer pageSize);

    UserResponse getUserById(Integer userId);
}
