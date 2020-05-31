package com.example.graduationproject.request;

import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/2/14
 * @Description:小冯同学写点注释吧！
 */
@Data
public class SelectAllCommentRequest {

    private Integer pageNumber = 1;

    private Integer size = 10;
}
