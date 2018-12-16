package com.sshop.core.model;
import java.math.BigDecimal;

import com.sshop.core.base.BaseModel;

@SuppressWarnings("serial")
public class OrderDetail extends BaseModel {
	
	private Integer id;
	private String orderNo;
	private String detailNo;
	private Integer goodsDetailId;
	private BigDecimal price; // 商品单价
	private Integer count; // 数量
	private String message; // 买家留言
	private String attr; // 用户属性
	private String ids; // 面料
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getDetailNo() {
		return detailNo;
	}
	public void setDetailNo(String detailNo) {
		this.detailNo = detailNo;
	}
	public Integer getGoodsDetailId() {
		return goodsDetailId;
	}
	public void setGoodsDetailId(Integer goodsDetailId) {
		this.goodsDetailId = goodsDetailId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
}
