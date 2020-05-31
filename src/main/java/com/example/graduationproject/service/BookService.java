package com.example.graduationproject.service;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.request.*;
import com.example.graduationproject.response.BookResponse;
import com.example.graduationproject.response.BookResponseList;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface BookService {
    /**
     * @param addBookRequest
     * @return
     */
    Integer addBook( AddBookRequest addBookRequest);

    /**
     * 管理员
     * @param id
     * @return
     */
    Integer delBook(Integer id);

    Integer delBookList(List<Integer> ids);

    /**
     *
     * @param book
     * @return
     */
    Integer updBook(Book book);


    /**
     * 读者
     * @param
     * @return
     */
    BookResponseList selBookByKeyWords(String keyWords,Integer pageSize,Integer pageNumber);

    BookResponseList selAllBook(Integer pageNumber,Integer size);

    BookResponseList selectBookByKindId(Integer bookKindId,Integer pageNumber,Integer size);

    Book selectBookById(Integer id);

    BookResponseList selectBookMount(Integer bookMount,Integer pageNumber,Integer size);

    BookResponseList getUserBook(Integer pageNumber, Integer pageSize);
}
