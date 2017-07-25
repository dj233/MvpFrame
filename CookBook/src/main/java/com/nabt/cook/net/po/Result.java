package com.nabt.cook.net.po;

/**
 * Created by 14k on 2017/7/26.
 */

public class Result<T> {

    /**
     * resultcode : 200
     * reason : Success
     * result : {}
     */

    private String resultcode;
    private String reason;
    private T result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
