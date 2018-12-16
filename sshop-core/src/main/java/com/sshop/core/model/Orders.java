package com.sshop.core.model;

import java.math.BigDecimal;
import java.util.Date;

import com.sshop.core.base.BaseModel;

@SuppressWarnings("serial")
public class Orders extends BaseModel {
	
	private Integer id;
	private String orderNo; // 订单号
	private String logisticsCode; // 物流订单号
	private String logisticsNo; // 物流单号
	private Integer producerId; // 生产者
	private Integer customerId; // 消费者
	private Integer addressId; // 收货地址
	private Date orderTime; // 下单时间
	private BigDecimal price; // 订单金额
	private Integer orderPreStatus; // 上一步状态
	private Integer orderStatus; // 订单状态详情请看OrderStatus 枚举
	private Date orderCompleteTime; // 订单完成时间
	private Date payTime; //支付时间
	private Integer payStatus; // 支付状态
	private String payNo; // 支付流水号
	private Date payCompleteTime; // 支付完成时间
	private String sqtk; // 退款理由
	private String dealwith; // 退款处理结果
	private int isReceive; // 确认收货 0-拒绝 1-确认
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
	public String getLogisticsCode() {
		return logisticsCode;
	}
	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}
	public String getLogisticsNo() {
		return logisticsNo;
	}
	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
	public Integer getProducerId() {
		return producerId;
	}
	public void setProducerId(Integer producerId) {
		this.producerId = producerId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getOrderPreStatus() {
		return orderPreStatus;
	}
	public void setOrderPreStatus(Integer orderPreStatus) {
		this.orderPreStatus = orderPreStatus;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderCompleteTime() {
		return orderCompleteTime;
	}
	public void setOrderCompleteTime(Date orderCompleteTime) {
		this.orderCompleteTime = orderCompleteTime;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public Date getPayCompleteTime() {
		return payCompleteTime;
	}
	public void setPayCompleteTime(Date payCompleteTime) {
		this.payCompleteTime = payCompleteTime;
	}
	public String getSqtk() {
		return sqtk;
	}
	public void setSqtk(String sqtk) {
		this.sqtk = sqtk;
	}
	public String getDealwith() {
		return dealwith;
	}
	public void setDealwith(String dealwith) {
		this.dealwith = dealwith;
	}
	public int getIsReceive() {
		return isReceive;
	}
	public void setIsReceive(int isReceive) {
		this.isReceive = isReceive;
	}
}
