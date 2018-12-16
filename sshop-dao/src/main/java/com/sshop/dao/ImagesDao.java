package com.sshop.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.Images;

public interface ImagesDao extends BaseDao<Images> {
	
	@Select("SELECT path FROM IMAGES WHERE detailCode = #{detailCode} "
			+ "and ( type=2 or type=4) and path != '' order by sort limit 1")
	public String findGoodsDetailImage(String code);
	
	@Select("SELECT path FROM IMAGES WHERE type = 0 and status = 0 and userId = #{userId}")
	public String findHeadImage(@Param(value = "userId")Integer userId);

	@Select("SELECT id, path, description FROM IMAGES WHERE goodsCode = #{goodsCode} and Type = 3")
	public List<Images> findGoodsImages(@Param(value = "goodsCode")String goodsCode);
	
	@Select("SELECT id, path, description FROM IMAGES WHERE goodsCode = #{goodsCode} and ( type=2 or type=4) group by detailCode")
	public List<Images> findDefaultPartImages(@Param(value = "goodsCode") String goodsCode);
	
	@Select("SELECT id, path, description FROM IMAGES WHERE id in (${ids})")
	public List<Images> findByIds(@Param(value="ids") String ids);
	
	
}
