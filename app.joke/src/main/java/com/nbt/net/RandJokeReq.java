package com.nbt.net;

import com.nbt.entity.Joke;
import com.nbt.entity.JokeRsp;

import java.util.List;

import lib.data.BaseReq;
import rx.Observable;

public class RandJokeReq extends BaseReq {
    private RandJokeApi jokeApi;
    private static RandJokeReq instance;

    private RandJokeReq(){
        jokeApi = mRetrofit.create(RandJokeApi.class);
    }

    public static RandJokeReq $(){
        if(instance == null){
            synchronized (BaseReq.class){
                instance = new RandJokeReq();
            }
        }
        return instance;
    }

    public Observable<JokeRsp<List<Joke>>> rand(String type){
        return jokeApi.rand(RandJokeApi.AppKey,type);
    }

    @Override
    protected String baseUrl() {
        return RandJokeApi.BASE_URL;
    }
}
