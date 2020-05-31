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

    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    public List<User> login(Long phoneNumber,String password) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("phoneNumber",phoneNumber)
                .andEqualTo("password",password);
        return userMapper.selectByExample(example);
    }

    public Integer delUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public Integer updUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> selectAll(Short mark) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("mark",mark);
        return userMapper.selectByExample(example);
    }

    public User getUserById(Integer userID) {
        /*Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("id",userID);
        return userMapper.selectByExample(example).get(0);*/
        return userMapper.selectByPrimaryKey(userID);
    }

    public List<User> exist(Long phoneNumber) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("phoneNumber",phoneNumber);
        return userMapper.selectByExample(example);
    }

    public List<User> selectAllUser() {
        return userMapper.selectAll();
    }

    public List<User> selectUserByKeyword(String keyword) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andLike("nickName","%"+keyword+"%");
        return userMapper.selectByExample(example);
    }
}
