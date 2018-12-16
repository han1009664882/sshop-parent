package com.sshop.core.vo;

import java.math.BigDecimal;

import com.sshop.core.base.BaseVo;
import com.sshop.core.model.Producer;

@SuppressWarnings("serial")
public class GoodsDetailVo extends BaseVo {
	
	private Integer id;//商品明细ID
	private String code;//商品明细编码
    private String goodsCode;//关联商品
    private String name;//商品名称
    private BigDecimal price;//商品价格
    private String images; //部件图片组合
    private Producer producer; // 生产者
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
}
