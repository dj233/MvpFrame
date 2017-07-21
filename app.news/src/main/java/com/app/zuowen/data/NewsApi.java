package com.app.zuowen.data;

import com.app.zuowen.entity.Channel;
import com.app.zuowen.entity.News;
import com.app.zuowen.entity.Rsp;
import com.app.zuowen.entity.Search;

import java.util.List;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface NewsApi {

    String URL = "http://api.jisuapi.com/";
    String AppKey = "7393247a3ce26f89";

    @POST("/news/channel")
    Observable<Rsp<List<String>>> getChannel(@Query("appkey")String appkey);

    @POST("/news/get")
    Observable<Rsp<Channel<News>>> getNews(@Query("appkey")String appkey,@Query("channel")String channel,@Query("start")int start,@Query("num")int num);

    @POST("/news/search")
    Observable<Rsp<Search<News>>> searchNews(@Query("appkey")String appkey, @Query("keyword")String keyword);
}
