package com.example.graduationproject.service;

import com.example.graduationproject.request.AddCommentRequest;
import com.example.graduationproject.request.CommentRequest;
import com.example.graduationproject.request.SelectAllCommentRequest;
import com.example.graduationproject.response.CommentResponseList;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */

public interface CommentService {
    Integer addComment(AddCommentRequest addCommentRequest);

    Integer deleteCommentById(Integer id);

    CommentResponseList selComment(Integer bookId,Integer pageNumber,Integer size);

    CommentResponseList selAllComment(Integer pageNumber,Integer size );
}
