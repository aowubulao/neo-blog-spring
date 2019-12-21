package com.neoniou.blog.service.impl;

import com.neoniou.blog.dao.CategoryDao;
import com.neoniou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author neo.zzj
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


}
