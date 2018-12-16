package com.sshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sshop.core.model.GoodsCategory;

public interface GoodsCategoryDao {
	
	@Select("select id, name from goods_category where isDefault = 0 order by sort desc")
	public List<GoodsCategory> findDefaultCategory();

	@Select("select name from goods_category where id = #{categoryId}")
	public String findCategoryName(@Param(value = "categoryId")Integer categoryId);

}
