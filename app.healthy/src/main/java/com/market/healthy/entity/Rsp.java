package com.market.healthy.entity;

import java.util.List;

public class Rsp<T> {

    /**
     * error_code : 0
     * reason : Success!
     * result : [{"name":"减肥瘦身","id":11},{"name":"私密生活","id":7},{"name":"女性保养","id":5}]
     */

    private int error_code;
    private String reason;
    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
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
