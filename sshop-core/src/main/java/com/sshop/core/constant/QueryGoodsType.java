package com.sshop.core.constant;

import com.sshop.core.exception.ParamException;

public enum QueryGoodsType {
	
	HOT("hot", "detailSaleCount.DESC", "热门商品"),
	
	NEW("new", "onlineDate.DESC", "最新商品"),
	
	CATEGORY("category", "detailSaleCount.DESC", "分类商品");
	
	private QueryGoodsType (){}
	
	private QueryGoodsType (String type, String sort, String title){
		this.type = type;
		this.sort = sort;
		this.title = title;
	}
	
	public String type; // 类型
	private String sort; // 排序字段
	private String title; // 排序字段
	
	/**
	 * 根据类型获取到某个值
	 * @param type
	 * @return
	 */
	public static QueryGoodsType findByType(String type) {
		for (QueryGoodsType queryGoodsType : QueryGoodsType.values()) {
			String $type = queryGoodsType.getType();
			if ($type.equals(type)) {
				return queryGoodsType;
			}
		}
		throw new ParamException("没有找到该类型，type=" + type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
