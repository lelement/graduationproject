package com.example.graduationproject.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * token缓存，存放token与对应的用户信息（这里存放的是用户手机号）
 */
@Data
public class TokenCache {
    private static TokenCache instance;

    private Map<String, String> tokenMap;

    private TokenCache() {
	tokenMap = new HashMap<>();
    }

    public static TokenCache getInstance() {
	if (instance == null) {
	    synchronized (TokenCache.class) {
		if (instance == null) {
		    instance = new TokenCache();
		}
	    }
	}
	return instance;
    }

    /**
     * 保存token与对应的手机号
     * @param token
     * @param phoneNumber 手机号
     */
    public void save(String token, String phoneNumber) {
	    tokenMap.put(token, phoneNumber);
    }

    /**
     * 根据token获取用户信息(手机号)
     * @param token
     * @return 手机号
     */
    public String getPhoneNumber(String token) {
	return tokenMap.get(token);
    }
}