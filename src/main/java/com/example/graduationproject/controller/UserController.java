package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.User;
import com.example.graduationproject.request.AddUserRequest;
import com.example.graduationproject.request.UpdateUserRequest;
import com.example.graduationproject.response.LoginResponse;
import com.example.graduationproject.response.UserResponse;
import com.example.graduationproject.response.UserResponseList;
import com.example.graduationproject.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/1/5
 * @Description:小冯同学写点注释吧！
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation("注册用户")
    @PostMapping("post/user")
    public SzpJsonResult<Integer> addUserByJson(@RequestBody AddUserRequest addUserRequest){
        //用户名是否已被注册使用
        if(userService.exist(addUserRequest.getPhoneNumber())==1){
            return new SzpJsonResult(401,"该账号已存在",null);
        }
        return SzpJsonResult.ok(userService.addUser(addUserRequest));
    }
    @ApiOperation("用户登录")
    @GetMapping("login")
    public SzpJsonResult<LoginResponse> login(@RequestParam(value = "phoneNumber",required = true) Long phoneNumber,
                                              @RequestParam(value = "password",required = true) String password){
        LoginResponse login = userService.login(phoneNumber, password);
        if (login.getToken() != null) {
            return SzpJsonResult.ok(login);
        } else {
            return new SzpJsonResult(401,"账号或密码错误",null);
        }
    }
    @ApiOperation("删除用户")
    @DeleteMapping("delete/user")
    public SzpJsonResult<Integer> delUserByJson(@RequestParam(value = "id",required = true)Integer id){
        return SzpJsonResult.ok(userService.delUser(id));
    }
    @ApiOperation("更新用户")
    @PutMapping("update/user")
    public SzpJsonResult<Integer> updUserByJson(@RequestBody UpdateUserRequest user){
        return SzpJsonResult.ok(userService.updUser(user));
    }

    @GetMapping("select/user")
    public SzpJsonResult<UserResponseList> selUserByJson(@RequestParam(value = "mark",defaultValue = "0")Short mark,
                                                         @RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                         @RequestParam(value = "size",defaultValue = "10") Integer pageSize){
        return SzpJsonResult.ok(userService.selUser(mark,pageNumber,pageSize));
    }

    @ApiOperation("查看全部用户")
    @GetMapping("select/all/user")
    public SzpJsonResult<UserResponseList> sellectAllUser(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                         @RequestParam(value = "size",defaultValue = "10") Integer pageSize){
        return SzpJsonResult.ok(userService.sellectAllUser(pageNumber,pageSize));
    }
    @ApiOperation("通过keyword查看用户")
    @GetMapping(value = "get/user/keyword")
    public SzpJsonResult<UserResponseList> selectUserByKeyword(@RequestParam(value = "keyword",defaultValue = "") @ApiParam(value = "关键字") String keyword,
                                                           @RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                            @RequestParam(value = "size",defaultValue = "10") Integer pageSize){
        return SzpJsonResult.ok(userService.selectUserByKeyword(keyword,pageNumber,pageSize));
    }

    @ApiOperation("通过userId查看用户")
    @GetMapping(value = "get/user/userId")
    public SzpJsonResult<UserResponse> getUserById(@RequestParam(value = "userId") Integer userId){
        return SzpJsonResult.ok(userService.getUserById(userId));
    }
}
