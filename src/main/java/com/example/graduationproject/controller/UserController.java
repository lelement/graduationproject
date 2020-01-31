package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.User;
import com.example.graduationproject.request.AddUserRequest;
import com.example.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author:Fengxutong
 * @Date:2020/1/5
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "select/all/admin")
    public SzpJsonResult<User> selectAllAdmin(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                              @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                              @RequestParam(value = "mark", defaultValue = "0") Integer mark){
        List<User> list = userService.selectAll(pageSize,pageNumber,mark);
        return SzpJsonResult.ok(list);
    }

    @GetMapping(value = "select/all/user")
    public SzpJsonResult<User> selectAllUser(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                             @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                             @RequestParam(value = "mark", defaultValue = "0") Integer mark){
        List<User> list = userService.selectAll(pageSize,pageNumber,mark);
        return SzpJsonResult.ok(list);
    }

    @PostMapping(value = "add/user")
    public SzpJsonResult<Integer> addUser(@RequestBody AddUserRequest addUserRequest){
        return SzpJsonResult.ok(userService.addUser(addUserRequest));
    }

    @PostMapping(value = "add/admin")
    public SzpJsonResult<Integer> addAdmin(@RequestBody AddUserRequest addUserRequest){
        return SzpJsonResult.ok(userService.addAdmin(addUserRequest));
    }

    @DeleteMapping(value = "delete/user/id")
    public SzpJsonResult<Integer> deleteUserById(@RequestParam Integer id){
        return SzpJsonResult.ok(userService.deleteById(id));
    }

    @DeleteMapping(value = "delete/user/ids")
    public SzpJsonResult<Integer> deleteUserByIds(@RequestBody List<Integer> ids){
        return SzpJsonResult.ok(userService.deleteByIds(ids));
    }

    @PutMapping(value = "update/user")
    public SzpJsonResult<Integer> updateUser(@RequestBody User user){
        return SzpJsonResult.ok(userService.updateUser(user));
    }

    @PutMapping(value = "update/admin")
    public SzpJsonResult<Integer> updateAdmin(@RequestBody User user){
        return SzpJsonResult.ok(userService.updateAdmin(user));
    }

}
