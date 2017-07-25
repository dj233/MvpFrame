package com.nabt.cook.net;

import com.nabt.cook.dao.entity.Book;
import com.nabt.cook.net.po.Data;
import com.nabt.cook.net.po.Result;
import com.nabt.cook.net.po.Tab;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 14k on 2017/7/26.
 */

public interface Api {
    public String AppKey = "2c5844ee9a3bd2b989be8211d8abad66";
    public String BaseUrl = "http://apis.juhe.cn/";

    @GET("/cook/category")
    Observable<Result<List<Tab>>> tabs(@Query("key")String appKey);

    @GET("/cook/index")
    Observable<Result<Data<Book>>> booksByType(@Query("key")String appKey, @Query("cid")String cid, @Query("pn")int page, @Query("rn")int pageSize);

    @GET("/cook/query.php")
    Observable<Result<Data<Book>>> booksByKeyword(@Query("key")String appKey, @Query("menu")String keyword, @Query("pn")int page, @Query("rn")int pageSize);
}
