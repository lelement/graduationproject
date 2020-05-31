package com.example.graduationproject.request;

import lombok.Data;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/14
 * @Description:小冯同学写点注释吧！
 */
@Data
public class DeleteBookByIdsRequest {
    List<Integer> ids;
}
