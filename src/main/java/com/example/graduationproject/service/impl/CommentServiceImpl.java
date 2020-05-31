package com.example.graduationproject.service.impl;


import com.example.graduationproject.dao.BookDao;
import com.example.graduationproject.dao.CommentDao;
import com.example.graduationproject.dao.UserDao;
import com.example.graduationproject.pojo.Comment;
import com.example.graduationproject.request.AddCommentRequest;
import com.example.graduationproject.response.CommentResponse;
import com.example.graduationproject.response.CommentResponseList;
import com.example.graduationproject.service.BookService;
import com.example.graduationproject.service.CommentService;
import com.example.graduationproject.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    CommentService commentService;
   @Autowired
   private BookDao bookDao;
   @Autowired
   private UserDao userDao;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;


    //用户对购买过书籍添加评论
    @Override
    @Transactional
    public Integer addComment(AddCommentRequest addCommentRequest) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(addCommentRequest,comment);
        comment.setCreateTime(new Date());
        return commentDao.addComment(comment);
    }


    //删除评论
    @Override
    public Integer deleteCommentById(Integer id) {
        return commentDao.delCommentById(id);
    }

    //用户通过bookId查看该书籍所有评论
    @Override
    public CommentResponseList selComment(Integer bookId,Integer pageNumber,Integer size) {
        PageHelper.startPage(pageNumber,size);
        List<Comment> commentList = commentDao.selComment(bookId);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        CommentResponseList commentResponseList = new CommentResponseList();
        List<CommentResponse> list = new ArrayList<>();
        for (Comment comment:pageInfo.getList()) {
            CommentResponse commentResponse = new CommentResponse();
            BeanUtils.copyProperties(comment,commentResponse);
            commentResponse.setUser(userDao.getUserById(comment.getUserId()));
            list.add(commentResponse);
        }
        commentResponseList.setCommentResponseList(list);
        commentResponseList.setTotal(pageInfo.getTotal());
        return commentResponseList;
    }

    @Override
    public CommentResponseList selAllComment(Integer pageNumber,Integer size) {
        PageHelper.startPage(pageNumber,size);
        List<Comment> commentList = commentDao.selectAll();
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        CommentResponseList commentResponseList = new CommentResponseList();
        List<CommentResponse> list = new ArrayList<>();
        for (Comment comment:pageInfo.getList()) {
            CommentResponse commentResponse = new CommentResponse();
            BeanUtils.copyProperties(comment,commentResponse);
            commentResponse.setUser(userDao.getUserById(comment.getUserId()));
            commentResponse.setBook(bookDao.selBookById(comment.getBookId()));
            list.add(commentResponse);
        }
        commentResponseList.setCommentResponseList(list);
        commentResponseList.setTotal(pageInfo.getTotal());
        return commentResponseList;
    }
}
