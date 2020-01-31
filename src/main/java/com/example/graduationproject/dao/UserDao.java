package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.UserMapper;
import com.example.graduationproject.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class UserDao {
    @Autowired
    UserMapper userMapper;

    public List<User> selectAll(Integer mark) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("mark",mark);
        return userMapper.selectByExample(example);
    }

    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    public Integer deleteUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteUserByIds(List<Integer> ids) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andIn("id",ids);
        return userMapper.deleteByExample(example);
    }

    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> select(User user) {
        return userMapper.select(user);
    }

    public User selectUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
