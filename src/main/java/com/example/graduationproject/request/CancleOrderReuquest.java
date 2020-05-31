package com.example.graduationproject.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-25 23:55.
 */
@Data
public class CancleOrderReuquest {
    @ApiModelProperty(value = "订单id")
    private Integer id;
    @ApiModelProperty(value = "书本数量")
    private Integer bookMount;
    @ApiModelProperty(value = "书籍id")
    private Integer bookId;
}

