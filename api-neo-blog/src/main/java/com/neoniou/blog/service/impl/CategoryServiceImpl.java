package com.neoniou.blog.service.impl;

import com.neoniou.blog.dao.CategoryDao;
import com.neoniou.blog.exception.ExceptionEnum;
import com.neoniou.blog.exception.NeoBlogException;
import com.neoniou.blog.pojo.Category;
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


    @Override
    public List<Category> getAllCategory() {
        return categoryDao.selectAll();
    }

    @Override
    public void addCategory(String categoryName) {
        Integer count = categoryDao.addCategory(categoryName);
    }

    @Override
    public boolean isHasCategory(String categoryName) {
        Integer count = categoryDao.queryCategoryCount(categoryName);
        return count == 1;
    }

    @Override
    public void deleteCategory(String categoryName) {
        categoryDao.deleteCategory(categoryName);
    }
}
