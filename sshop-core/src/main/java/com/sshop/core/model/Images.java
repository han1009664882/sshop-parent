package com.sshop.core.model;

import com.sshop.core.base.BaseModel;

/**
 * 图片
 */
@SuppressWarnings("serial")
public class Images extends BaseModel {

    private String goodsCode;  //商品code
    private String detailCode;  //商品详情code
    private Integer partId;  //部件id
    private Integer userId;  //用户id
    private Integer id;       //id
    private Integer sort;     //排序
    /**
     * ImagesType   图片类型
     */
    private Integer type;       //图片类型

	//图片路径
    private String path;
    //图片描述
    private String description;
    //图片状态 0=有效 1=无效
    private Integer status;
    //图片名称
    private String imagesName;

    public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

    public String getGoodsCode() {
        return goodsCode;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    public Images() {
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImagesName() {
        return imagesName;
    }

    public void setImagesName(String imagesName) {
        this.imagesName = imagesName;
    }

	@Override
	public String toString() {
		return "Images [goodsCode=" + goodsCode + ", detailCode=" + detailCode + ", partId=" + partId + ", userId="
				+ userId + ", id=" + id + ", sort=" + sort + ", type=" + type + ", path=" + path + ", description="
				+ description + ", status=" + status + ", imagesName=" + imagesName + "]";
	}
    
}
