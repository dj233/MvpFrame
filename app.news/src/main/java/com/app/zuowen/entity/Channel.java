package com.app.zuowen.entity;

import java.util.List;

public class Channel<T> {

    /**
     * channel : 头条
     * num : 10
     * list : []
     */

    private String channel;
    private String num;
    private List<T> list;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
