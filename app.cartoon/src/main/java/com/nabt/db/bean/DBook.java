package com.nabt.db.bean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "DBOOK".
 */
public class DBook {

    private String name;
    private String type;
    private String area;
    private String des;
    private Boolean finish;
    private Integer lastUpdate;
    private String coverImg;

    public DBook() {
    }

    public DBook(String name) {
        this.name = name;
    }

    public DBook(String name, String type, String area, String des, Boolean finish, Integer lastUpdate, String coverImg) {
        this.name = name;
        this.type = type;
        this.area = area;
        this.des = des;
        this.finish = finish;
        this.lastUpdate = lastUpdate;
        this.coverImg = coverImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public Integer getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

}
