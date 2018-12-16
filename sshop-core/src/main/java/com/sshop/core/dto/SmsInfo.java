package com.sshop.core.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SmsInfo implements Serializable {
	
	private int randomNum;
	private String mobile;
	public int getRandomNum() {
		return randomNum;
	}
	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public SmsInfo() {
	}
	public SmsInfo(int randomNum, String mobile) {
		super();
		this.randomNum = randomNum;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "SmsInfo [randomNum=" + randomNum + ", mobile=" + mobile + "]";
	}
}
