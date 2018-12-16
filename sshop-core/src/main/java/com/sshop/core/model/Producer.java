package com.sshop.core.model;

import com.sshop.core.base.BaseModel;

@SuppressWarnings("serial")
public class Producer extends BaseModel {
	
	// 主键
    private Integer id;
    //手机号码
    private String mobile;
    //用户名
    private String lastname;
    //头像
    private String header ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
}
