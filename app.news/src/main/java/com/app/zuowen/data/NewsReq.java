package com.app.zuowen.data;

import com.app.zuowen.entity.Channel;
import com.app.zuowen.entity.News;
import com.app.zuowen.entity.Rsp;
import com.app.zuowen.entity.Search;

import java.util.List;

import lib.data.BaseReq;
import rx.Observable;

public class NewsReq extends BaseReq{
    private static NewsReq _inst;
    private NewsApi api;


    private NewsReq(){
        api = mRetrofit.create(NewsApi.class);
    }

    public static NewsReq $(){
        if(_inst == null){
            synchronized (NewsReq.class){
                _inst = new NewsReq();
            }
        }
        return _inst;
    }


    @Override
    protected String baseUrl() {
        return NewsApi.URL;
    }

    public Observable<Rsp<List<String>>> getChannel(){
        return api.getChannel(NewsApi.AppKey);
    }

    public Observable<Rsp<Channel<News>>> getNews(String channel,int start,int limit){
        return api.getNews(NewsApi.AppKey,channel,start,limit);
    }

    public Observable<Rsp<Search<News>>> searchNews(String keyword){
        return api.searchNews(NewsApi.AppKey,keyword);
    }
}
