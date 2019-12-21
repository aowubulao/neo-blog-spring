package com.neoniou.blog.dao;

import com.neoniou.blog.pojo.Category;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author neo.zzj
 */
@Repository
public interface CategoryDao extends Mapper<Category> {

}
