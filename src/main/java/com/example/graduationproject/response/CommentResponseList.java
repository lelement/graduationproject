package com.example.graduationproject.response;

import lombok.Data;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/12
 * @Description:小冯同学写点注释吧！
 */
@Data
public class CommentResponseList {
    private List<CommentResponse> commentResponseList;
    private Long total;
}
