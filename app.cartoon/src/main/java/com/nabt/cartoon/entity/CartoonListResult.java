package com.nabt.cartoon.entity;

import java.util.List;

public class CartoonListResult {
    /**
     * comicName : 虹色妖姬
     * chapterId : 227893
     * imageList : []
     */

    private String comicName;
    private int chapterId;
    private List<Cartoon> imageList;

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public List<Cartoon> getImageList() {
        return imageList;
    }

    public void setImageList(List<Cartoon> imageList) {
        this.imageList = imageList;
    }
}
