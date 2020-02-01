package com.example.graduationproject.response;

import com.example.graduationproject.pojo.Book;
import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/1/31
 * @Description:小冯同学写点注释吧！
 */
@Data
public class BookResponse {
    private Book book;

    private Integer saleMount;
}
