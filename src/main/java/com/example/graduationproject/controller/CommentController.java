package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.response.CommentResponse;
import com.example.graduationproject.service.CommentService;
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

    /*@PostMapping("add/comment/by/json")
    public SzpJsonResult<UserOrderCommentShip> addComment(@RequestBody AddCommentRequest addCommentRequest, @RequestBody AddOrderRequest addOrderRequest) {
        Integer result =  commentService.addComment(addCommentRequest,addOrderRequest);
        return SzpJsonResult.ok(result);
    }*/


    @DeleteMapping("delete/comment/by/id")
    public SzpJsonResult<Integer> delComment(@RequestParam Integer id){
        return SzpJsonResult.ok(commentService.deleteCommentById(id));
    }


    @GetMapping("get/all/comment")
    public SzpJsonResult<CommentResponse> selComment(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber){
        return SzpJsonResult.ok(commentService.selAllComment(pageNumber,pageSize));
    }

   /* @GetMapping("get/comment/by/bookid/{bookid}")
    public SzpJsonResult<CommentResponse> getCommentByBookId(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                                     @PathVariable(value = "bookid") Integer bookId){
        return SzpJsonResult.ok(commentService.getCommentByBookId(bookId,pageNumber,pageSize));
    }*/
}
