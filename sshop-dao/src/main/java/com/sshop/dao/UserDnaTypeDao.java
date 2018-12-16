package com.sshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.UserDnaType;

public interface UserDnaTypeDao extends BaseDao<UserDnaType> {
	
	/**
	 * 获取商品默认的DNA
	 * @param goodsCode
	 * @return
	 */
	public List<UserDnaType> findGoodsDefaultDna(@Param(value="goodsCode")String goodsCode);
	
	/**
	 * 获取商品的其他属性
	 * @param code
	 * @return
	 */
	public List<UserDnaType> findGoodsDna(@Param(value="goodsCode") String goodsCode);

}
