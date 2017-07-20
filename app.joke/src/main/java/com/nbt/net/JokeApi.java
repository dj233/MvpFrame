package com.nbt.net;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface JokeApi {

    @GET("/joke/img/text.from")
    public Observable<JokeRsp> newPic(@Query("key") String appKey, @Query("page") int page, @Query("pagesize") int pagesize);

    @GET("/joke/content/text.from")
    public Observable<JokeRsp> newTxt(@Query("key") String appKey, @Query("page") int page, @Query("pagesize") int pagesize);



}
