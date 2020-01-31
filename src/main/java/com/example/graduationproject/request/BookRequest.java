package com.example.graduationproject.request;

import lombok.Data;

import java.util.Date;

@Data
public class BookRequest {
    private String bookName;

    private Double price;

    private String writerName;

    private Integer mount;

    private Integer bookKindId;

    private String production;
}