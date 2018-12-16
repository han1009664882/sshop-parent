package com.sshop.dao;

import org.apache.ibatis.annotations.Param;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.Goods;

public interface GoodsDao extends BaseDao<Goods> {
	
	/**
	 * 根据商品的code获取商品详情
	 * @param goodsCode
	 * @return
	 */
	public Goods findByCode(@Param(value = "goodsCode") String goodsCode);
	
	/**
	 * 根据子商品的I点更新总数量
	 * @param amount
	 * @param goodDetailId
	 * @return
	 */
	public int updaeSaleCount(@Param(value = "amount")int amount,
			@Param(value = "goodDetailId")Integer goodDetailId);
	
}
