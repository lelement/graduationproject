package com.example.graduationproject.service.impl;
import	java.util.ArrayList;


import com.example.graduationproject.dao.*;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.Comment;
import com.example.graduationproject.pojo.User;
import com.example.graduationproject.response.CommentResponse;
import com.example.graduationproject.service.CommentService;
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
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;


    @Transactional
    @Override
    public Integer deleteCommentById(Integer id) {
        return commentDao.delCommentById(id);
    }

    @Override
    public List<CommentResponse> selAllComment(Integer pageNumber, Integer pageSize) {
        List<CommentResponse> commentResponseList = new ArrayList<>();
        List<Comment> comments = commentDao.selectAll();
        for (Comment comment:comments){
            CommentResponse commentResponse = new CommentResponse();
            BeanUtils.copyProperties(comment,commentResponse);
            Book book = bookDao.selBookById(comment.getBookId());
            User user = userDao.selectUserById(comment.getUserId());
            commentResponse.setBook(book);
            commentResponse.setPhoneNumer(user.getPhoneNumber());
            commentResponse.setImgUrl(user.getImgUrl());
            commentResponseList.add(commentResponse);
        }
        return commentResponseList;
    }


}
