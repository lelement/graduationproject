package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.request.AddBookRequest;
import com.example.graduationproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("add/book/{kindId}")
    public SzpJsonResult<Integer> addBookByJson(@PathVariable(value = "kindId") Integer kindId,AddBookRequest addBookRequest) throws IOException {
        return SzpJsonResult.ok(bookService.addBook(kindId,addBookRequest));
    }

    @PostMapping("add/books/byList")
    public SzpJsonResult<Integer> addBookByList(@RequestBody List<Book> books){

        return SzpJsonResult.ok(bookService.addBookList(books));
    }


    @DeleteMapping("delete/book/by/id")
    public SzpJsonResult<Integer> delBook(@RequestParam("id") Integer id){
        return SzpJsonResult.ok(bookService.delBook(id));
    }


    @PutMapping("update/book/by/json")
    public SzpJsonResult<Integer> updBook(@RequestBody Book book){
        return SzpJsonResult.ok(bookService.updBook(book));
    }

    @GetMapping("get/book/by/keywords")
    public SzpJsonResult<Book> findBookByKeyWords(@RequestParam(value = "keywords", defaultValue = "")String keywords,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                  @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber){
        return SzpJsonResult.ok(bookService.selBook(keywords,pageNumber,pageSize));
    }

    @GetMapping("select/all/book/")
    public SzpJsonResult<Book> selectAllBook(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                             @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber){
        return SzpJsonResult.ok(bookService.selAllBook(pageNumber,pageSize));
    }

    @GetMapping("count/sell/book/")
    public SzpJsonResult<Integer> selectsellBookNumber(Integer bookId){
        return SzpJsonResult.ok(bookService.selectsellBookNumber(bookId));
    }


}
