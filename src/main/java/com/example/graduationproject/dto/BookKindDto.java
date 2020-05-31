package com.example.graduationproject.dto;

/**
 * Created by NiuLilu on 2020-05-28 14:51.
 */

import com.example.graduationproject.pojo.BookKind;
import lombok.Data;

@Data
public class BookKindDto extends BookKind {
    private String bookKindUrl;
}
