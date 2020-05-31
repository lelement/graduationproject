package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.BookDao;
import com.example.graduationproject.dao.BookKindDao;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.request.*;
import com.example.graduationproject.response.BookResponse;
import com.example.graduationproject.response.BookResponseList;
import com.example.graduationproject.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookKindDao bookKindDao;


    @Override
    public Integer addBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(addBookRequest,book);
        book.setCreateTime(new Date());
        return bookDao.addBook(book);
    }

    @Override
    public Integer delBook(Integer id) {
        return bookDao.delBook(id);
    }

    @Override
    public Integer delBookList(List<Integer> ids) {
        return bookDao.deleteBookByIds(ids);
    }


    @Override
    public Integer updBook(Book book) {
        return bookDao.updBook(book);
    }



    /**
     * 根据书名或者作者姓名查询相关书籍
     */
    @Override
    public BookResponseList selBookByKeyWords(String keyWords,Integer pageSize,Integer pageNumber) {
        BookResponseList bookResponseList = new BookResponseList();
        PageHelper.startPage(pageNumber, pageSize);
        List<Book> all = null;
        if (!StringUtils.isEmpty(keyWords)) {
            all = bookDao.selBook(keyWords);
        }else {
            all= bookDao.selectAllBook();
        }
        PageInfo<Book> pageInfo=new PageInfo<>(all);
        List<BookResponse> list = new ArrayList<>();
        for (Book book:pageInfo.getList()){
            BookResponse bookResponse = new BookResponse();
            BeanUtils.copyProperties(book,bookResponse);
            bookResponse.setKindName(bookKindDao.slectTypeById(book.getBookKindId()).getKindName());
            list.add(bookResponse);
        }
        bookResponseList.setList(list);
        bookResponseList.setTotal(pageInfo.getTotal());
        return bookResponseList;
    }

    /**
     * 管理员查看所有的书籍
     * @return
     */
    @Override
    public BookResponseList selAllBook(Integer pageNumber,Integer size) {
        BookResponseList bookResponseList = new BookResponseList();
        PageHelper.startPage(pageNumber,size);
        List<Book> all = bookDao.selectAllBook();
        PageInfo<Book> pageInfo=new PageInfo<>(all);
        List<BookResponse> list = new ArrayList<>();
        for (Book book:pageInfo.getList()){
            BookResponse bookResponse = new BookResponse();
            BeanUtils.copyProperties(book,bookResponse);
            bookResponse.setKindName(bookKindDao.slectTypeById(book.getBookKindId()).getKindName());
            list.add(bookResponse);
        }
        bookResponseList.setList(list);
        bookResponseList.setTotal(pageInfo.getTotal());
        return bookResponseList;
    }

    @Override
    public BookResponseList selectBookByKindId(Integer bookKindId,Integer pageNumber,Integer size) {
        BookResponseList bookResponseList = new BookResponseList();
        PageHelper.startPage(pageNumber,size);
        List<Book> all = bookDao.selectBookByBookKindId(bookKindId);
        PageInfo<Book> pageInfo=new PageInfo<>(all);
        List<BookResponse> list = new ArrayList<>();
        for (Book book:pageInfo.getList()){
            BookResponse bookResponse = new BookResponse();
            BeanUtils.copyProperties(book,bookResponse);
            bookResponse.setKindName(bookKindDao.slectTypeById(book.getBookKindId()).getKindName());
            list.add(bookResponse);
        }
        bookResponseList.setList(list);
        bookResponseList.setTotal(pageInfo.getTotal());
        return bookResponseList;
    }

    @Override
    public Book selectBookById(Integer id) {
        return bookDao.selBookById(id);
    }

    @Override
    public BookResponseList selectBookMount(Integer mount,Integer pageNumber,Integer size) {
        BookResponseList bookResponseList = new BookResponseList();
        List<Book> all = bookDao.selectBookByMount(mount);
        PageHelper.startPage(pageNumber,size);
        PageInfo<Book> pageInfo=new PageInfo<>(all);
        List<BookResponse> list = new ArrayList<>();
        for (Book book:pageInfo.getList()){
            BookResponse bookResponse = new BookResponse();
            BeanUtils.copyProperties(book,bookResponse);
            bookResponse.setKindName(bookKindDao.slectTypeById(book.getBookKindId()).getKindName());
            list.add(bookResponse);
        }
        bookResponseList.setList(list);
        bookResponseList.setTotal(pageInfo.getTotal());
        return bookResponseList;
    }

    @Override
    public BookResponseList getUserBook(Integer pageNumber, Integer pageSize) {
        BookResponseList bookResponseList = new BookResponseList();
        PageHelper.startPage(pageNumber,pageSize);
        List<Book> all = bookDao.selectAllBook();
        Collections.shuffle(all);
        PageInfo<Book> pageInfo=new PageInfo<>(all);
        List<BookResponse> list = new ArrayList<>();
        for (Book book:pageInfo.getList()){
            BookResponse bookResponse = new BookResponse();
            BeanUtils.copyProperties(book,bookResponse);
            bookResponse.setKindName(bookKindDao.slectTypeById(book.getBookKindId()).getKindName());
            list.add(bookResponse);
        }
        bookResponseList.setList(list);
        bookResponseList.setTotal(pageInfo.getTotal());
        return bookResponseList;
    }
}
