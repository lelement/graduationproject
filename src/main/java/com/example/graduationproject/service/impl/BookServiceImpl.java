package com.example.graduationproject.service.impl;

import com.example.graduationproject.dao.BookDao;
import com.example.graduationproject.dao.OrderItemDao;
import com.example.graduationproject.pojo.Book;
import com.example.graduationproject.pojo.OrderItem;
import com.example.graduationproject.request.AddBookRequest;
import com.example.graduationproject.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    BookDao bookDao;
    @Autowired
    OrderItemDao orderItemDao;

    @Override
    public Integer addBook(Integer kindId,AddBookRequest addBookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(addBookRequest,book);
        book.setBookKindId(kindId);
        return bookDao.addBook(book);
    }

    @Override
    public Integer addBookList(List<Book> books) {
        return bookDao.addBookList(books);
    }

    @Override
    public Integer delBook(Integer id) {
        return bookDao.delBook(id);
    }

    @Override
    public Integer delBooks(List<Integer> ids) {
        return bookDao.deleteBookByIds(ids);
    }

    @Override
    public Integer updBook(Book book) {
        return bookDao.updBook(book);
    }

    @Override
    public List<Book> selectBook(Integer mount) {
        return null;
    }

    /**
     * 根据书名或者作者姓名查询相关书籍
     */
    @Override
    public List<Book> selBook(String name,Integer pageNumber,Integer pageSize) {
        //开始分页，必须写在上面
        PageHelper.startPage(pageNumber,pageSize);
        List<Book> all = bookDao.selBook(name);
        PageInfo<Book> pageInfo=new PageInfo<>(all);
        log.info("all-{}",all);
        log.info("pageInfo.getList()-{}",pageInfo.getList());
        log.info("pagesize-{},pageNumber-{}",pageSize,pageNumber);
        return pageInfo.getList();
    }

    @Override
    public List<Book> selAllBook(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Book> all = bookDao.selectAllBook();
        PageInfo<Book> pageInfo=new PageInfo<>(all);
        return pageInfo.getList();
    }

    @Override
    public Integer selectsellBookNumber(Integer bookId) {
        List<OrderItem> orderItemList = orderItemDao.selectsellBookNumber(bookId);
        Integer count = 0;
        for (OrderItem orderItem:orderItemList){
            Integer mount = orderItem.getMount();
            count+=mount;
        }
        return count;
    }

}
