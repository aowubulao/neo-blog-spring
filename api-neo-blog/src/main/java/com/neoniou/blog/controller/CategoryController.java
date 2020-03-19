package com.neoniou.blog.controller;

import com.neoniou.blog.exception.ExceptionEnum;
import com.neoniou.blog.exception.NeoBlogException;
import com.neoniou.blog.pojo.Category;
import com.neoniou.blog.pojo.Post;
import com.neoniou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author neo.zzj
 */
@RestController
@RequestMapping("/blog/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取所有分类
     * @return Categories
     */
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory() {
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }

    /**
     * 添加 Category
     * @param categoryName category_name
     */
    @PostMapping("{categoryName}")
    public ResponseEntity<Void> addCategory(@PathVariable("categoryName") String categoryName,
                                            @RequestParam("token") String token) {
        if (!categoryService.isHasCategory(categoryName)) {
            categoryService.addCategory(categoryName);
        } else {
            throw new NeoBlogException(ExceptionEnum.CATEGORY_REPEAT);
        }
        return ResponseEntity.ok().build();
    }

    /**
     * 删除 Category
     * @param categoryName category_name
     */
    @DeleteMapping("{categoryName}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("categoryName") String categoryName,
                                               @RequestParam("token") String token) {
        categoryService.deleteCategory(categoryName);
        return ResponseEntity.ok().build();
    }
}
