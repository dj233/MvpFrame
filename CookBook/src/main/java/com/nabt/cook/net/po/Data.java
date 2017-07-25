package com.nabt.cook.net.po;

import com.nabt.cook.dao.entity.Book;

import java.util.List;

/**
 * Created by 14k on 2017/7/26.
 */

public class Data<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
