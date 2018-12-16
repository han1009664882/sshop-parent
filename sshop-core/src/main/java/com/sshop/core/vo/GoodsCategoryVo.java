package com.sshop.core.vo;

import com.sshop.core.base.BaseVo;

@SuppressWarnings("serial")
public class GoodsCategoryVo extends BaseVo {
	
	 //id
    private Integer id;
    //分类名称
    private String  name;
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
}
