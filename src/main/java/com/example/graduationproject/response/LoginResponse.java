package com.example.graduationproject.response;

import com.example.graduationproject.pojo.User;
import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-24 13:33.
 */
@Data
public class LoginResponse {
    private User user;

    private String token;
}
