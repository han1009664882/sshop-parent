package com.sshop.core.constant;

public enum OrderStatus {

	//	0-提交订单，等待支付结果。
	WATTING(0),

	//	1-订单支付，支付成功。
	Pay_SUCCESS(1),

	//	48小时内申请退款
	RETURN_WITHIN_48(2),

	//	3-商家不接单，自动退款状态。
	_Refund_(3),

	//	4-商家已接单，生产中。
	_Production_(4),

	//	6-已发货。
	_Shipments_(6),

	//	7-已签收。
	_Sign_for_(7),

	//	8-确认签收状态。
	_Affirm_Sign_(8),

	//	9-订单关闭（已完成）
	_Close_Order_(9),

	//	10-消费者申请退货。
	_Return_Request_(10),

	//	11-商家同意退款。
	_Agree_Return_(11),

	//	12-商家不同意退款，争议中。
	_In_Dispute_(12),


	//	14-平台处理争议订单完毕
	_Terrace_SUCCESS_(14),

	//生产者不接单，已退款。
	NOT_AGREE_ORDER(15),

	//半小时自动取消订单
	HALF_RETURN(100);

	private int value;

	private OrderStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static OrderStatus valueOf(int value) {
		for (OrderStatus s : OrderStatus.values()) {
			if (s.getValue() == value) {
				return s;
			}
		}
		throw new IllegalArgumentException("Connot find value " + value + " in eunu PayStatus.");
	}
}
