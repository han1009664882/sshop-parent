package com.sshop.sms.log;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SmsLog implements Serializable {
	
	private String mobile;
	private Integer randomNum;
	private Date sendTime;
	private String sendResult;
	private String smsTemplateCode;
	private int sendType; // 0=发送验证码 1=购买成功的短信
	private Integer userId;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getRandomNum() {
		return randomNum;
	}
	public void setRandomNum(Integer randomNum) {
		this.randomNum = randomNum;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getSendResult() {
		return sendResult;
	}
	public void setSendResult(String sendResult) {
		this.sendResult = sendResult;
	}
	public String getSmsTemplateCode() {
		return smsTemplateCode;
	}
	public void setSmsTemplateCode(String smsTemplateCode) {
		this.smsTemplateCode = smsTemplateCode;
	}
	public int getSendType() {
		return sendType;
	}
	public void setSendType(int sendType) {
		this.sendType = sendType;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}	
