package com.sshop.core.model;

import java.util.List;

import com.sshop.core.base.BaseModel;

@SuppressWarnings("serial")
public class GoodsPart extends BaseModel {
	
	private Integer id;
	private String name;
	private Integer goodsId;
	private List<Images> images;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public List<Images> getImages() {
		return images;
	}
	public void setImages(List<Images> images) {
		this.images = images;
	}
}
