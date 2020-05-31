package com.example.graduationproject.response;



import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-11 11:34.
 */

@Data
public class BookResponseList {
    private List<BookResponse> list;

    private Long total;
}
