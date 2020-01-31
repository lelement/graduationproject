package com.example.graduationproject.service.impl;


import com.example.graduationproject.dao.CommentDao;
import com.example.graduationproject.pojo.Comment;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.pojo.UserOrderCommentShip;
import com.example.graduationproject.request.AddCommentRequest;
import com.example.graduationproject.service.CommentService;
import com.example.graduationproject.service.UserOrderCommentShipService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Autowired
    UserOrderCommentShipService userOrderCommentShipService;


    @Override
    public Integer deleteCommentById(Integer id) {
        return commentDao.delCommentById(id);
    }

    @Override
    public List<Comment> selAllComment(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Comment> list = commentDao.selectAll();
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }

    @Override
    public List<Comment> getCommentByBookId(Integer bookId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Comment> list = commentDao.getCommentByBookId(bookId);
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }
}
