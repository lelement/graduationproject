package com.example.graduationproject.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AddBookRequest {

    private String bookName;

    private Double price;

    private String writerName;
    @ApiModelProperty(value = "书库中剩余数量")
    private Integer mount;

    private String imgUrl;

    private String production;
    @ApiModelProperty(value = "类别id")
    private Integer bookKindId;

}