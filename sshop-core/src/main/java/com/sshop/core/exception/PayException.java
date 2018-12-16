package com.sshop.core.exception;

import com.sshop.core.constant.Constant;

/**
 * Created by Tony on 2016/8/22.
 */
@SuppressWarnings("serial")
public class PayException extends RuntimeException {

    private int errorCode;

    public  PayException() {
    }
    public PayException(String message) {
        super(message);
        this.errorCode = Constant.RESULT_ERROR;
    }
    public PayException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
