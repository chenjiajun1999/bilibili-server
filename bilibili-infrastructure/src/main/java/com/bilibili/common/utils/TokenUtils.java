package com.bilibili.common.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.cola.exception.BizException;

import java.util.HashMap;
import java.util.Map;

public class TokenUtils {


    private static final String TOKEN_KEY = "bilibili";

    public static String generateToken(Long userId) {

        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;

            {
                put("uid", String.valueOf(userId));
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            }
        };

        return JWTUtil.createToken(map, TOKEN_KEY.getBytes());
    }

    public static Long verifyToken(String token) {

        if (!JWTUtil.verify(token, TOKEN_KEY.getBytes())) {
            throw new BizException("B_TOKEN_tokenInvalid", "无效 Token");
        }

        final JWT jwt = JWTUtil.parseToken(token);
        return Long.valueOf((String) jwt.getPayload("uid"));
    }
}
