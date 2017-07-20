package com.nbt.net;

public class Joke {


    /**
     * content : 这鱼我怎么抓不到？
     * hashId : B0C3ABBEBBE0A6EA5B8FE04E27215FBC
     * unixtime : 1418965236
     * updatetime : 2014-12-19 13:00:36
     * url : http://img.juhe.cn/joke/201412/19/B0C3ABBEBBE0A6EA5B8FE04E27215FBC.gif
     */

    private String content;
    private String hashId;
    private int unixtime;
    private String updatetime;
    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(int unixtime) {
        this.unixtime = unixtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "content='" + content + '\'' +
                ", hashId='" + hashId + '\'' +
                ", unixtime=" + unixtime +
                ", updatetime='" + updatetime + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
