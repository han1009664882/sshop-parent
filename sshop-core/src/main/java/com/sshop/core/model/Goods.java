package com.sshop.core.model;

import java.util.Date;

import com.sshop.core.base.BaseModel;

@SuppressWarnings("serial")
public class Goods extends BaseModel {
	
	private Integer id;
	private String code;
	private Integer type; // 0=小微商家 1=实力生产商
	private Integer categoryId; // 类型 goods_category
	private Integer dnaId; // dna_value
	private Integer userId; // 生产商ID user表里
	private String description; // 描述
	private String origin; // 制作原由
	private String reviews; // 制作心得
	private Integer saleCount; // 销量
	private Integer collectCount; // 收藏数量
	private Integer commentCount; // 评论数量
	private Date createTime;
	private Date updateTime;
	private Integer status; // 状态: 0=有效 1-发布失败 ，2-发布中, 3-审核中，4-用户提交商品审核
	private Integer realeaseStep; // 发布产品步骤。0-选择发布类型 1-发布第一步 2-发布第二步
	private String productCycle; // 生产周期
	private Integer isdelete; // 0=未删除 1=删除
	private String note; // 备注：拒绝原因
	private String place; // 产地
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getDnaId() {
		return dnaId;
	}
	public void setDnaId(Integer dnaId) {
		this.dnaId = dnaId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Integer getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}
	public Integer getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRealeaseStep() {
		return realeaseStep;
	}
	public void setRealeaseStep(Integer realeaseStep) {
		this.realeaseStep = realeaseStep;
	}
	public String getProductCycle() {
		return productCycle;
	}
	public void setProductCycle(String productCycle) {
		this.productCycle = productCycle;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
}
