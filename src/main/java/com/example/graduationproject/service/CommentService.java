package com.example.graduationproject.service;

import com.example.graduationproject.pojo.Comment;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.request.AddCommentRequest;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */

public interface CommentService {

    Integer deleteCommentById(Integer id);

    List<Comment> selAllComment(Integer pageNumber, Integer pageSize);

    List<Comment> getCommentByBookId(Integer bookId, Integer pageNumber, Integer pageSize);
}
