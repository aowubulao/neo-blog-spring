package com.neoniou.blog.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Neo.Zzj
 */
public class RedisUtil {

    private JedisPool jedisPool;

    public RedisUtil() {
        jedisPool = new JedisPool("127.0.0.1");
    }

    /**
     * Get value by key
     * @param key key
     * @return value
     */
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    /**
     * Set key-value with expire time
     * @param key key
     * @param value key-value
     * @param second expire time
     */
    public void setKeyWithExpire(String key, String value, int second) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
        jedis.expire(key, second);
        jedis.close();
    }

    /**
     * Set key's expire time
     * @param key key
     * @param second expire time
     */
    public void setExpire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        jedis.expire(key, second);
        jedis.close();
    }

    /**
     * Determine if Key exists
     * @param key key
     * @return true or false
     */
    public Boolean isExist(String key) {
        Jedis jedis = jedisPool.getResource();
        Boolean isExists = jedis.exists(key);
        jedis.close();
        return isExists;
    }
}
