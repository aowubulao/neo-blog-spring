package com.neoniou.blog.service;

/**
 * 初始化博客数据库接口
 * Init blog database interface
 *
 * @author neo.zzj
 */
public interface InitService {

    /**
     * 查询数据库是否需要初始化
     * @return true:需要初始化 false:不需要初始化
     */
    Boolean isNeedInit();

    /**
     * 初始化数据库，创建博客所需要的表
     */
    void initDatabase();
}
