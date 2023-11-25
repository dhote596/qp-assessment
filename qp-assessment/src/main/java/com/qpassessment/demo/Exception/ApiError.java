package com.qpassessment.demo.Exception;

public class ApiError {

    private Integer errorCode;
    private String msg;

    public ApiError(Integer errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
