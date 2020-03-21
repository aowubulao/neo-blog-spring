package com.neoniou.blog.util;

import java.util.Random;

/**
 * @author Neo.Zzj
 */
public class TokenUtil {

    private static final int TOKEN_LENGTH = 32;
    private static final String CODE_STR = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    private static final String UNDEFINED = "undefined";

    private RedisUtil redisUtil;

    public TokenUtil() {
        redisUtil = new RedisUtil();
    }

    /**
     * Generate token
     * @return token
     */
    public String generateToken() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= TOKEN_LENGTH; i++) {
            int index = random.nextInt(CODE_STR.length());
            char cr = CODE_STR.charAt(index);
            stringBuilder.append(cr);
        }
        return stringBuilder.toString();
    }

    public Boolean authToken(String token) {
        if (isExists(token)) {
            extendToken(token);
            return true;
        } else {
            return false;
        }
    }

    public Boolean isExists(String token) {
        return redisUtil.isExist(token);
    }

    /**
     * 设置 Token (第一次)
     * 过时时间为一天
     * @param token token
     */
    public void setToken(String token) {
        redisUtil.setKeyWithExpire(token, "token", 60 * 60 * 24);
    }

    /**
     * Token再次被请求，过期时间再次设置为一天
     * @param token token
     */
    public void extendToken(String token) {
        redisUtil.setExpire(token, 60 * 60 * 24);
    }

    public boolean checkToken(String token) {
        if (token == null || UNDEFINED.equals(token) || token.length() != TOKEN_LENGTH) {
            return false;
        }
        return token.matches("[A-Z0-9]+");
    }
}
