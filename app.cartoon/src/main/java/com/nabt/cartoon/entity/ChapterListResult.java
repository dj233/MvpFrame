package com.nabt.cartoon.entity;

import java.util.List;

public class ChapterListResult {

    /**
     * total : 16
     * comicName : 虹色妖姬
     * chapterList : []
     */

    private int total;
    private String comicName;
    private List<Chapter> chapterList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }
}
