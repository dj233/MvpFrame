package com.nbt.net;

import com.nbt.entity.Joke;
import com.nbt.entity.JokeRsp;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RandJokeApi {

    String AppKey = "c400a0c176c41a0ed0bd33839eeedc70";
    String BASE_URL = "http://v.juhe.cn/";

    @GET("/joke/randJoke.php")
    Observable<JokeRsp<List<Joke>>> rand(@Query("key") String appKey, @Query("type") String page);

}
