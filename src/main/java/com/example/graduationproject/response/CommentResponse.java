package com.example.graduationproject.response;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.User;
import lombok.Data;

/**
 * Created by lemon on 2020-01-31 0:31.
 */
@Data
public class CommentResponse {
    private User user;

    private Book book;

    private String content;

    private Integer book_star;

}
