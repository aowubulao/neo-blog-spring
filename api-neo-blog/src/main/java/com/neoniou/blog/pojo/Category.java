package com.neoniou.blog.pojo;

import javax.persistence.Table;

/**
 * @author neo.zzj
 */
@Table(name = "nb_category")
public class Category {

    private Integer categoryId;
    private String categoryName;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
