package com.neoniou.blog.service.impl;

import com.neoniou.blog.common.ILocalCache;
import com.neoniou.blog.dao.CategoryDao;
import com.neoniou.blog.pojo.Category;
import com.neoniou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author neo.zzj
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    @SuppressWarnings("unchecked")
    public List<Category> getAllCategory() {
        if (ILocalCache.isExist(ILocalCache.CATEGORIES)) {
            return (List<Category>) ILocalCache.get(ILocalCache.CATEGORIES);
        } else {
            List<Category> categories = categoryDao.selectAll();
            ILocalCache.add(ILocalCache.CATEGORIES, categories);
            return categories;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCategory(String categoryName) {
        Integer count = categoryDao.addCategory(categoryName);
    }

    @Override
    public boolean isHasCategory(String categoryName) {
        Integer count = categoryDao.queryCategoryCount(categoryName);
        return count == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCategory(String categoryName) {
        categoryDao.deleteCategory(categoryName);
    }
}
