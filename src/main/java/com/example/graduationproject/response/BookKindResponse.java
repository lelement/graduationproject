package com.example.graduationproject.response;

import com.example.graduationproject.dto.BookKindDto;
import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-11 14:23.
 */
@Data
public class BookKindResponse {
    private List<BookKindDto> bookKindList;

}
