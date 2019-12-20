package com.neoniou.blog.service.impl;

import com.neoniou.blog.dao.InitDao;
import com.neoniou.blog.exception.ExceptionEnum;
import com.neoniou.blog.exception.NeoBlogException;
import com.neoniou.blog.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 初始化博客数据库
 * Init blog database
 *
 * @author neo.zzj
 */
@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private InitDao initDao;

    @Override
    public Boolean isNeedInit() {
        int count = initDao.queryInitTableName();
        return count == 0;
    }

    @Override
    public void initDatabase() {
        initDao.dropTableUser();
        initDao.createTableUser();

        initDao.dropTablePost();
        initDao.createTablePost();

        initDao.dropTableComment();
        initDao.createTableComment();
    }
}
