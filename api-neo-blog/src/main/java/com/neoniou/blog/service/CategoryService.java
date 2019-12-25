package com.neoniou.blog.service;

import com.neoniou.blog.pojo.Category;
import com.neoniou.blog.pojo.Post;

import java.util.List;

/**
 * @author neo.zzj
 */
public interface CategoryService {

    /**
     * 获取所有分类
     * @return Categories
     */
    List<Category> getAllCategory();

    /**
     * 添加 Category
     * @param categoryName category_name
     */
    void addCategory(String categoryName);

    /**
     * 判断 category 是否存在
     * @param categoryName category_name
     * @return true: exist
     */
    boolean isHasCategory(String categoryName);

    /**
     * 删除 Category
     * @param categoryName category_name
     */
    void deleteCategory(String categoryName);
}
