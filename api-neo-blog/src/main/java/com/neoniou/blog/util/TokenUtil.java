package com.neoniou.blog.util;

import java.util.Random;

/**
 * @author Neo.Zzj
 */
public class TokenUtil {

    private static final int TOKEN_LENGTH = 32;
    private static final String CODE_STR = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";

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

    public Boolean isExists(String token) {
        return redisUtil.isExist(token);
    }

    public void setToken(String token) {
        redisUtil.setKeyWithExpire(token, "token", 60 * 60 * 24 * 3);
    }
}
