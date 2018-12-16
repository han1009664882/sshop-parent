package com.sshop.core.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseOrder implements Serializable {
	
	private String orderNo;
	private String price; // 订单总金额 保留两位小数
	private String goodsName; // 商品名称
	private String goodsDesc; // 商品描述
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
}
