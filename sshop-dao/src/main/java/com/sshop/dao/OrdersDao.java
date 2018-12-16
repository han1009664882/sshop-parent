package com.sshop.dao;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.Orders;

public interface OrdersDao extends BaseDao<Orders> {
	
	/**
	 * 查询订单的基本信息
	 * @param orderNo
	 * @return
	 */
	public Orders findByOrderNo(String orderNo);
	
	/**
	 * 更新支付相关的状态
	 * @param orders
	 */
	public void updateAfterPay(Orders orders);

}
