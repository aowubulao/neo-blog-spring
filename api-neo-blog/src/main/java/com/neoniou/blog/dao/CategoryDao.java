package com.neoniou.blog.dao;

import com.neoniou.blog.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author neo.zzj
 */
@Repository
public interface CategoryDao extends Mapper<Category> {


    /**
     * 添加 Category
     * @param categoryName category_name
     * @return count
     */
    @Insert("insert into nb_category (category_name) values (#{categoryName})")
    Integer addCategory(String categoryName);

    /**
     * 判断 category 是否可添加
     * @param categoryName category_name
     * @return category count
     */
    @Select("select count(category_id) from nb_category where category_name = #{categoryName}")
    Integer queryCategoryCount(String categoryName);

    /**
     * 删除 Category
     * @param categoryName category_name
     */
    @Delete("delete from nb_category where category_name = #{categoryName}")
    void deleteCategory(String categoryName);
}
