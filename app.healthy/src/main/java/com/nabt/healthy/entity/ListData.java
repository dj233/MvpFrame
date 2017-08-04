package com.nabt.healthy.entity;

import java.util.List;

public class ListData<T> {

    /**
     * total : 18207
     * data : [{"count":27,"description":"警惕！这6类人吃粗粮易使癌细胞疯长 《这是真的么》第23期：一个部位长肉竟是癌症先兆时长：5'58''播放：682384来源：腾讯视频《这是真的么》第23期：一个部位长肉竟是癌症先兆关闭自动播放相关专辑推荐视频：收起视频正在播放现代生活的精细化和精致化，成为诸多营养疾病的诱因","fcount":0,"id":18209,"img":"http://tnfs.tngou.net/image/lore/150829/75ddc66c2c011fc5471bde4d218f12e5.jpg","keywords":"粗粮 人群 健康 吸收 营养素 ","loreclass":3,"rcount":0,"time":1440811364000,"title":"一些特殊体质的人就不宜常吃粗粮"},{"count":21,"description":"研究称：床头朝向竟能影响人类寿命 心肌炎、哮喘、心力衰竭：采取半躺半坐的睡姿，可改善肺部的血液循环，减少肺部瘀血，增加氧气的吸入量，有利于症状的缓解与休息","fcount":0,"id":18208,"img":"http://tnfs.tngou.net/image/lore/150829/bfd758579579fee7cd0a3ba1231c1c2a.jpg","keywords":"睡姿 侧卧 侧卧位 睡眠 心脏 ","loreclass":12,"rcount":0,"time":1440811364000,"title":"人睡觉时应该采用头北脚南的朝向"},"..."]
     */

    private int total;
    private List<T> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
