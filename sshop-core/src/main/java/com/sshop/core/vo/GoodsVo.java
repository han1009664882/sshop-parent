package com.sshop.core.vo;

import java.util.List;

import com.sshop.core.model.GoodsPart;
import com.sshop.core.model.Images;
import com.sshop.core.model.UserDnaType;

@SuppressWarnings("serial")
public class GoodsVo extends GoodsDetailVo {
	
	private Integer goodsId; // 商品主键
	private String description; // 描述
	private String origin; // 制作原由
	private String reviews; // 制作心得
	private Integer type; // 0=小微商家 1=实力生产商
	
	private List<Images> goodsImages; // 商品图片
	private List<GoodsPart> goodsParts; // 商品零部件
	private List<UserDnaType> attributes; // 商品属性
	private List<UserDnaType> defaultAttributes; // 商品属性
	
	public List<GoodsPart> getGoodsParts() {
		return goodsParts;
	}
	public void setGoodsParts(List<GoodsPart> goodsParts) {
		this.goodsParts = goodsParts;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public List<Images> getGoodsImages() {
		return goodsImages;
	}
	public void setGoodsImages(List<Images> goodsImages) {
		this.goodsImages = goodsImages;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public List<UserDnaType> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<UserDnaType> attributes) {
		this.attributes = attributes;
	}
	public List<UserDnaType> getDefaultAttributes() {
		return defaultAttributes;
	}
	public void setDefaultAttributes(List<UserDnaType> defaultAttributes) {
		this.defaultAttributes = defaultAttributes;
	}
}
