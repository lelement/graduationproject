package com.example.graduationproject.request;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lemon on 2020-02-11 11:23.
 */
@Data
public class SearchBookRequest {
    private String keywords;
    private Integer pageSize=10;
    private Integer pageNumber=1;
}
