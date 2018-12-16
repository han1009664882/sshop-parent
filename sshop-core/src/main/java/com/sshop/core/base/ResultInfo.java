package com.sshop.core.base;

import com.sshop.core.constant.Constant;

/**
 * Created by Tony on 2016/8/22.
 */
public class ResultInfo {

    private int resultCode = Constant.RESULT_OK;
    private Object result;
    private String message;

    public ResultInfo() {
        super();
    }
    public ResultInfo(int resultCode) {
        super();
        this.resultCode = resultCode;
    }
    public ResultInfo(Object result) {
        super();
        this.result = result;
        this.message = Constant.OPT_SUCCESS;
    }
    public ResultInfo(String message) {
        super();
        this.result = Constant.RESULT_ERROR;
        this.message = message;
    }
    public ResultInfo(int resultCode, Object result, String message) {
        super();
        this.resultCode = resultCode;
        this.result = result;
        this.message = message;
    }
    public int getResultCode() {
        return resultCode;
    }
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResultInfo [resultCode=" + resultCode + ", result=" + result + ", message=" + message + "]";
	}
}
