package com.app.zuowen.entity;

import java.util.List;

public class Search<T> {

    /**
     * keyword : 关键词
     * num : 10
     * list : []
     */

    private String keyword;
    private String num;
    private List<T> list;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
