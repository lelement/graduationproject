package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.request.AddCommentRequest;
import com.example.graduationproject.request.CommentRequest;
import com.example.graduationproject.request.SelectAllCommentRequest;
import com.example.graduationproject.response.CommentResponseList;
import com.example.graduationproject.service.CommentService;
import com.example.graduationproject.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    OrderService orderService;

    @ApiOperation("添加评论")
    @PostMapping("add/comment")
    public SzpJsonResult<Integer> addComment(@RequestBody AddCommentRequest addCommentRequest) {
        return SzpJsonResult.ok(commentService.addComment(addCommentRequest));
    }

    @DeleteMapping("delete/comment")
    public SzpJsonResult<Integer> delComment(@RequestParam(value = "id") Integer id){
        return SzpJsonResult.ok(commentService.deleteCommentById(id));
    }

    @GetMapping("get/comment/{bookId}")
    public SzpJsonResult<CommentResponseList> selCommentByBookId(@RequestParam(value = "bookId") Integer bookId,@RequestParam(value = "pageNumber") Integer pageNumber,@RequestParam(value = "size") Integer size){
        return SzpJsonResult.ok(commentService.selComment(bookId,pageNumber,size));
    }

    @GetMapping("get/comment")
    public SzpJsonResult<CommentResponseList> selComment(@RequestParam(value = "pageNumber") Integer pageNumber,@RequestParam(value = "size") Integer size){
        return SzpJsonResult.ok(commentService.selAllComment(pageNumber,size));
    }
}
