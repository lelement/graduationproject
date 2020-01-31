package com.example.graduationproject.service;

import com.example.graduationproject.pojo.User;
import com.example.graduationproject.request.AddUserRequest;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface UserService {
    List<User> selectAll(Integer pageSize, Integer pageNumber, Integer mark);

    Integer addUser(AddUserRequest addUserRequest);

    Integer addAdmin(AddUserRequest addUserRequest);

    Integer deleteById(Integer id);

    Integer deleteByIds(List<Integer> ids);

    Integer updateUser(User user);

    Integer updateAdmin(User user);
}
