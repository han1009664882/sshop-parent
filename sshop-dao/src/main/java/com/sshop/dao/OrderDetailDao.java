package com.sshop.dao;

import java.util.List;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.OrderDetail;

public interface OrderDetailDao extends BaseDao<OrderDetail> {
	
	/**
	 * 根据订单号查询订单的基本信息
	 * @param orderNo
	 * @return
	 */
	public Integer findGoodsDetailIdByOrderNo(String orderNo);
	
	/**
	 * 根据订单好获取订单详情
	 * @param orderNo
	 * @return
	 */
	public List<OrderDetail> findByOrderNo(String orderNo);

}
