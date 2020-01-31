package com.example.graduationproject.controller;

import com.example.graduationproject.common.SzpJsonResult;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.BookKind;
import com.example.graduationproject.request.AddBookKindRequest;
import com.example.graduationproject.service.BookKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class BookKindController {
    @Autowired
    BookKindService bookKindService;

    @PostMapping(value = "add/bookKind")
    public SzpJsonResult<Integer> addBookKind(@RequestBody AddBookKindRequest addBookKindRequest){
        return SzpJsonResult.ok(bookKindService.addBookKind(addBookKindRequest));
    }


    @DeleteMapping(value = "delete/bookKind")
    public SzpJsonResult<Integer> delBookKind(@RequestParam Integer id){
        return SzpJsonResult.ok(bookKindService.delBookKind(id));
    }

    @PutMapping(value = "update/bookKind")
    public SzpJsonResult<Integer> updBookKind(@RequestBody BookKind bookKind){
        return SzpJsonResult.ok(bookKindService.updBookKind(bookKind));
    }

    @GetMapping(value = "get/all/book/kind")
    public SzpJsonResult<BookKind> getAllBookKind(){
        return SzpJsonResult.ok(bookKindService.selectAllBookKind());
    }
}
