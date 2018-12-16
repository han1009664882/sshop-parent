package com.sshop.core.model;

import java.math.BigDecimal;
import java.util.List;

import com.sshop.core.base.BaseModel;

/**
 * 商品明细
 */
@SuppressWarnings("serial")
public class GoodsDetail extends BaseModel {

	private Integer id;//商品明细ID
    private String code;//商品明细编码
    private String goodsCode;//关联商品
    private Integer status;//商品的发布状态
    private String name;//商品名称
    private BigDecimal price;//商品价格
    private String images; //部件图片组合
    private List<Images> detailImages;//成品图片

    private Integer producerId; // 生产者ID

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }



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

	public List<Images> getDetailImages() {
		return detailImages;
	}

	public void setDetailImages(List<Images> detailImages) {
		this.detailImages = detailImages;
	}

	public Integer getProducerId() {
		return producerId;
	}

	public void setProducerId(Integer producerId) {
		this.producerId = producerId;
	}

	@Override
	public String toString() {
		return "GoodsDetail [code=" + code + ", goodsCode=" + goodsCode + ", id=" + id + ", status=" + status
				+ ", name=" + name + ", price=" + price + ", images=" + images + ", detailImages=" + detailImages
				+ ", toString()=" + super.toString() + "]";
	}


    
    
}
