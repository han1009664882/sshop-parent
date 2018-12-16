package com.sshop.core.query;

import com.sshop.core.base.BaseQuery;

@SuppressWarnings("serial")
public class GoodsQuery extends BaseQuery {
	
	private String type; // hot new category
	private Integer categoryId; // 类别ID

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}
