package com.example.graduationproject.response;

import com.example.graduationproject.pojo.Book;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;


/**
 * @Author:Fengxutong
 * @Date:2020/1/31
 * @Description:小冯同学写点注释吧！
 */
@Data
public class BookResponse {
    private Integer id;

    private String bookName;

    private Double price;

    private String writerName;

    private Date createTime;

    /**
     * 书库中剩余数量
     */
    private Integer mount;

    private String imgUrl;

    private Integer bookKindId;

    private String kindName;

    private String production;

    /**
     * 销售数量
     */
    private Integer saleMount;
}
