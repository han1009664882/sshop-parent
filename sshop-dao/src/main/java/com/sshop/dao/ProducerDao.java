package com.sshop.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sshop.core.model.Producer;

public interface ProducerDao {
	
	/**
	 * 获取商品生产者的信息
	 * @param producerId
	 * @return
	 */
	@Select("select id, mobile, lastname from user where id = #{producerId}")
	public Producer findGoodsProducer(@Param(value="producerId")Integer producerId);
	
}
