package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.BookMapper;
import com.example.graduationproject.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class BookDao {
    @Autowired
    BookMapper bookMapper;

    /**
     * 管理员权限
     * */
    public Integer addBook(Book book) {
        return bookMapper.insert(book);
    }

    public Integer deleteBookByIds(List<Integer> ids) {
        Example example = new Example(Book.class);
        example.createCriteria()
                .andIn("id",ids);
        return bookMapper.deleteByExample(example);
    }

    /**
     * 管理员权限
     * */
    public Integer delBook(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    /**
     * 管理员权限
     * */
    public Integer updBook(Book book) {
        return bookMapper.updateByPrimaryKeySelective(book);
    }

    public List<Book> selBook(String name) {
        Example bookExample = new Example(Book.class);
        bookExample.createCriteria()
                .andLike("bookName","%"+name+"%")
                .orLike("writerName","%"+name+"%");
        return bookMapper.selectByExample(bookExample);
    }

    /**
     * 管理员权限   保留
     * */
    public List<Book> selBook(Integer mount) {
        Example bookExample = new Example(Book.class);
        bookExample.createCriteria().andEqualTo("mount",0);
        return bookMapper.selectByExample(bookExample);
    }



    public List<Book> selectAllBook() {
        return bookMapper.selectAll();
    }

    public Book selBookById(Integer bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    public List<Book> selectBookByBookKindId(Integer bookKindId) {
        Example example = new Example(Book.class);
        example.createCriteria()
                .andEqualTo("bookKindId",bookKindId);
        return bookMapper.selectByExample(example);
    }

    public Book selectBookByBookId(Integer bookId){
        return bookMapper.selectByPrimaryKey(bookId);
    }

    public List<Book> selectBookByMount(Integer mount) {
        Example example = new Example(Book.class);
        example.createCriteria()
                .andEqualTo("mount",mount);
        return bookMapper.selectByExample(example);
    }
}
