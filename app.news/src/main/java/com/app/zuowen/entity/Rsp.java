package com.app.zuowen.entity;

public class Rsp<T> {

    /**
     * status : 0
     * msg : ok
     * result :
     */

    private String status;
    private String msg;
    private T result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
