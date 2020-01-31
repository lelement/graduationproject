package com.example.graduationproject.mapper;

import com.example.graduationproject.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends CommonMapper<Book> {
}