package com.example.graduationproject.service;

import com.example.graduationproject.pojo.BookKind;
import com.example.graduationproject.request.AddBookKindRequest;
import com.example.graduationproject.response.BookKindResponse;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
public interface BookKindService {
    /**
     * 添加种类
     * */
    Integer addBookKind(AddBookKindRequest addBookKindRequest);


    Integer delBookKind(Integer id);

    Integer updBookKind(BookKind bookKind);

    BookKindResponse selectAllBookKind();
}
