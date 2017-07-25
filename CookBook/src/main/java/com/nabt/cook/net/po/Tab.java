package com.nabt.cook.net.po;

import com.nabt.cook.dao.entity.Type;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 14k on 2017/7/26.
 */

public class Tab implements Serializable {


    /**
     * parentId : 10001
     * name : 菜式菜品
     * list : []
     */

    private String parentId;
    private String name;
    private List<Type> list;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Type> getList() {
        return list;
    }

    public void setList(List<Type> list) {
        this.list = list;
    }
}
