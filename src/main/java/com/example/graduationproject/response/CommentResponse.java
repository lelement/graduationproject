package com.example.graduationproject.response;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.Order;
import com.example.graduationproject.pojo.User;
import lombok.Data;

import java.util.Date;

/**
 * Created by lemon on 2020-01-31 0:31.
 */
@Data
public class CommentResponse {
    private Integer id;

    private String imgUrl;

    private Long phoneNumer;

    private Book book;

    private String content;

    private Date createTime;

}
