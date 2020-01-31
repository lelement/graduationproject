package com.example.graduationproject.mapper;

import com.example.graduationproject.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends CommonMapper<User> {
}