package com.neoniou.blog.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Neo.Zzj
 */
public class ILocalCache {

    private static Map<String, Object> cache = new ConcurrentHashMap<>(64);

    public static final String BLOG_INFO = "blogInfo";
    public static final String CATEGORIES = "categories";

    public static void add(String key, Object o) {
        cache.put(key, o);
    }

    public static Object get(String key) {
        return cache.get(key);
    }

    public static void remove(String key) {
        cache.remove(key);
    }

    public static boolean isExist(String key) {
        return cache.containsKey(key);
    }

    public static void clear() {
        cache = new ConcurrentHashMap<>(64);
    }

}
