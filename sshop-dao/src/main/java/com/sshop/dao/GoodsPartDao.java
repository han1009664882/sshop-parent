package com.sshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.GoodsPart;

public interface GoodsPartDao extends BaseDao<GoodsPart> {
	
	/**
	 * 获取商品的零部件
	 * @param goodsId
	 * @return
	 */
	public List<GoodsPart> findGoodsPart(@Param(value="goodsId")Integer goodsId);
	
}
