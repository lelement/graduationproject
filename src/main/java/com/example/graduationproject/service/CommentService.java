package com.example.graduationproject.service;

import com.example.graduationproject.response.CommentResponse;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */

public interface CommentService {

    Integer deleteCommentById(Integer id);

    List<CommentResponse> selAllComment(Integer pageNumber, Integer pageSize);

    
}
