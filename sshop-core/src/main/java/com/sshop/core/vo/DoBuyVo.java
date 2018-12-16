package com.sshop.core.vo;

import java.io.Serializable;
import java.util.List;

import com.sshop.core.model.Images;

@SuppressWarnings("serial")
public class DoBuyVo implements Serializable {
	
	private GoodsDetailVo goods; // 商品信息
	private List<Images> partsImages; // 其他商品信息
	private Integer detailId; // 商品详情id
	private String token; // 防止重复提交
	private String dna; // 用户数据
	private String ids; // 获取其他商品信息的图片id 多个以逗号分隔
	
	public GoodsDetailVo getGoods() {
		return goods;
	}
	public void setGoods(GoodsDetailVo goods) {
		this.goods = goods;
	}
	public List<Images> getPartsImages() {
		return partsImages;
	}
	public void setPartsImages(List<Images> partsImages) {
		this.partsImages = partsImages;
	}
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
}
