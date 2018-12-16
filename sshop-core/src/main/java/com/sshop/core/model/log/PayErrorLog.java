package com.sshop.core.model.log;

import java.util.Date;

import com.sshop.core.dto.PayCallbackParams;

@SuppressWarnings("serial")
public class PayErrorLog extends PayCallbackParams {
	
	private String errorMessage;
	private Integer errorCode;
	private Date createDate;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
