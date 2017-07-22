package com.nbt.net;

import com.nbt.entity.JokeData;
import com.nbt.entity.JokeRsp;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface JokeApi {

    String AppKey = "c400a0c176c41a0ed0bd33839eeedc70";
    String BASE_URL = "http://japi.juhe.cn";

    @GET("/joke/img/text.from")
    Observable<JokeRsp<JokeData>> newPic(@Query("key") String appKey, @Query("page") int page, @Query("pagesize") int pagesize);

    @GET("/joke/content/text.from")
    Observable<JokeRsp<JokeData>> newTxt(@Query("key") String appKey, @Query("page") int page, @Query("pagesize") int pagesize);


}
