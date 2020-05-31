package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.request.*;
import com.example.graduationproject.response.BookResponse;
import com.example.graduationproject.response.BookResponseList;
import com.example.graduationproject.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 添加书籍
     * @param addBookRequest
     * @return
     */
    @ApiOperation("添加书籍")
    @PostMapping("post/book")
    public SzpJsonResult<Integer> addBookByJson(@RequestBody AddBookRequest addBookRequest) {
        return SzpJsonResult.ok(bookService.addBook(addBookRequest));
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    @DeleteMapping("delete/book")
    public SzpJsonResult<Integer> delBook(@RequestParam("id") Integer id){
        return SzpJsonResult.ok(bookService.delBook(id));
    }

    /**
     * 批量删除
     * @param
     * @return
     */
    @DeleteMapping("delete/book/by/Ids")
    public SzpJsonResult<Integer> delBooks(@RequestBody DeleteBookByIdsRequest deleteBookByIdsRequest){
        return SzpJsonResult.ok(bookService.delBookList(deleteBookByIdsRequest.getIds()));
    }

    @ApiOperation("更新书籍")
    @PutMapping("update/book")
    public SzpJsonResult<Integer> updBook(@RequestBody Book bookRequest){
        return SzpJsonResult.ok(bookService.updBook(bookRequest));
    }

    /**
     * 关键字搜索
     * @return
     */
    @ApiOperation("关键字搜索")
    @GetMapping("get/book/by/keyWords")
    public SzpJsonResult<BookResponseList> selectBookByKeyWords(@RequestParam(value = "keyWords",defaultValue = "",required = false) String keyWords,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber){
        return SzpJsonResult.ok(bookService.selBookByKeyWords(keyWords,pageSize,pageNumber));
    }

    /**
     * 管理员查看所有的书籍
     * @return
     */
    @ApiOperation("管理员查看所有的书籍")
    @GetMapping("get/all/book")
    public SzpJsonResult<BookResponseList> selectAllBook(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return SzpJsonResult.ok(bookService.selAllBook(pageNumber,pageSize));
    }

    /**
     * 用户首页浏览
     * @return
     */
    @ApiOperation("用户首页浏览")
    @GetMapping("get/user/book")
    public SzpJsonResult<BookResponseList> getUserBook(@RequestParam(value = "pageNumber") Integer pageNumber,@RequestParam(value = "pageSize") Integer pageSize){
        return SzpJsonResult.ok(bookService.getUserBook(pageNumber,pageSize));
    }

    /**
     * 分类查找
     * @return
     */
    @ApiOperation("分类查找")
    @GetMapping("get/book/kindId")
    public SzpJsonResult<BookResponseList> selectBookByKindId(@RequestParam(value = "kindId") Integer kindId,
                                                              @RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                              @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return SzpJsonResult.ok(bookService.selectBookByKindId(kindId, pageNumber, pageSize));
    }

    /**
     * 根据id查
     * @param id
     * @return
     */
    @ApiOperation("根据id查")
    @GetMapping("select/book")
    public SzpJsonResult<Book> selectBookById(@RequestParam Integer id){
        return SzpJsonResult.ok(bookService.selectBookById(id));
    }

    @GetMapping("select/book/ByMount")
    public SzpJsonResult<BookResponseList> selectBookByMount(@RequestParam(value = "mount") Integer mount,@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return SzpJsonResult.ok(bookService.selectBookMount(mount,pageNumber,pageSize));
    }
}
