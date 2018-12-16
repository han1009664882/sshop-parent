package com.sshop.core.constant;

/**
 * 商品状态
 */
public enum GoodsStatus {

	_SUCCESS_(0),

	_FAIL_(1),

	// 发布中
	_releasing_(2),

	//小薇上传第一步 的点击按钮
	_uploading_(4),
	
	/**
	 * 审核中
	 */
	_audit_(3);

	private GoodsStatus(int value) {
		this.value = value;
	}

	private int value;

	public int getValue() {
		return value;
	}

	public int Status() {
		return value;
	}

	public static GoodsStatus valueOf(int value) {
		for (GoodsStatus s : GoodsStatus.values()) {
			if (s.getValue() == value) {
				return s;
			}
		}
		throw new IllegalArgumentException("Connot find value " + value + " in eunu PayStatus.");
	}
}
