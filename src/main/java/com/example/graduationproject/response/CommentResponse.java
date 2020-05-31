package com.example.graduationproject.response;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.User;
import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/1/31
 * @Description:小冯同学写点注释吧！
 */
@Data
public class CommentResponse {
    private Integer id;

    private String content;

    /**
     * 评论时间
     **/
    private String createTime;

    private Integer bookId;

    private Book book;

    private User user;

}
