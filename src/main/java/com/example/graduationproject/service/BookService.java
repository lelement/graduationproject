package com.example.graduationproject.service;

import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.request.AddBookRequest;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface BookService {
    /**
     *
     * @param kindId
     * @param addBookRequest
     * @return
     */
    Integer addBook(Integer kindId,AddBookRequest addBookRequest);


    /**
     *  保 留
     * @param books
     * @return
     */
    Integer addBookList(List<Book> books);
    /**
     * 管理员
     * @param id
     * @return
     */
    Integer delBook(Integer id);

    Integer delBooks(List<Integer> ids);

    /**
     *
     * @param book
     * @return
     */
    Integer updBook(Book book);

    /**
     * 管理员    保留
     * @param mount
     * @return
     */
    List<Book> selectBook(Integer mount);

    /**
     * 读者
     * @param key
     * @return
     */
    List<Book> selBook(String key, Integer pageNumber, Integer pageSize);

    List<Book> selAllBook(Integer pageNumber, Integer pageSize);

    Integer selectsellBookNumber(Integer bookId);
}
