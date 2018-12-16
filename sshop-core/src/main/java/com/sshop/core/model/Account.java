package com.sshop.core.model;


import com.sshop.core.base.BaseModel;


@SuppressWarnings("serial")
public class Account extends BaseModel {
	private Integer id;
	private String pwd;
	private Integer usable;
	private Integer locked;
	private String code18;
	private String name;
	private String phone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getUsable() {
		return usable;
	}
	public void setUsable(Integer usable) {
		this.usable = usable;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public String getCode18() {
		return code18;
	}
	public void setCode18(String code18) {
		this.code18 = code18;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
