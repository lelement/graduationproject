package com.example.graduationproject.request;

import lombok.Data;

@Data
public class AddBookRequest {
    private String bookName;

    private Double price;

    private String writerName;

    private Integer mount;

    private String imgUlr;


}