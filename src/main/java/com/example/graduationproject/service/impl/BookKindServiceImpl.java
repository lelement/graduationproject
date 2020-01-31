package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.BookKindDao;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.BookKind;
import com.example.graduationproject.request.AddBookKindRequest;
import com.example.graduationproject.service.BookKindService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Service
public class BookKindServiceImpl implements BookKindService {
    @Autowired
    BookKindDao bookKindDao;
    @Override
    public Integer addBookKind(AddBookKindRequest addBookKindRequest) {
        BookKind bookKind = new BookKind();
        BeanUtils.copyProperties(addBookKindRequest,bookKind);
        return bookKindDao.addBookKind(bookKind);
    }


    @Override
    public Integer delBookKind(Integer id) {
        return bookKindDao.delBookKind(id);
    }

    @Override
    public Integer updBookKind(BookKind bookKind) {
        return bookKindDao.updBookKind(bookKind);
    }

    @Override
    public List<BookKind> selectAllBookKind() {
        return bookKindDao.selectAll();
    }

    }
