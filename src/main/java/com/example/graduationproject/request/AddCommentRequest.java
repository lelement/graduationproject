package com.example.graduationproject.request;

import lombok.Data;

import javax.persistence.Column;

/**
 * @Author:Fengxutong
 * @Date:2020/1/11
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AddCommentRequest {
    private Integer userId;

    private Integer bookId;

    private Integer orderItemId;

    private String content;

}
