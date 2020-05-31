package com.example.graduationproject.response;

import com.example.graduationproject.pojo.ReceivedInfo;
import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-11 14:36.
 */
@Data
public class ReceivedInfoResponseList {
        private List<ReceivedInfo> list;

        private Long total;
}
