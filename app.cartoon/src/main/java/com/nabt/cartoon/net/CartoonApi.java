package com.nabt.cartoon.net;

import com.nabt.cartoon.entity.BookListResult;
import com.nabt.cartoon.entity.CartoonListResult;
import com.nabt.cartoon.entity.ChapterListResult;
import com.nabt.cartoon.entity.Rsp;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface CartoonApi {
    String URL = "http://japi.juhe.cn/";
    String AppKey = "45094d97e813ae20f61e9c62b06b28b8";

    @GET("/comic/book")
    Observable<Rsp<BookListResult>> listBook(@Query("key")String appKey,@Query("name")String keyword,@Query("type")String type,@Query("skip")String skip,@Query("finish")int isFinish);

    @GET("/comic/chapter")
    Observable<Rsp<ChapterListResult>> listChapter(@Query("key")String appKey,@Query("comicName")String comicName,@Query("skip")String skip);

    @GET("/comic/chapterContent")
    Observable<Rsp<CartoonListResult>> listCartoon(@Query("key")String appKey,@Query("comicName")String comicName,@Query("id")int chapterId);

}
