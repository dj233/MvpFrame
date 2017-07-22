package com.nbt.net;

import com.nbt.entity.JokeData;
import com.nbt.entity.JokeRsp;

import lib.data.BaseReq;
import rx.Observable;

public class JokeReq extends BaseReq {
    private JokeApi jokeApi;
    private static JokeReq instance;

    private JokeReq(){
        jokeApi = mRetrofit.create(JokeApi.class);
    }

    public static JokeReq $(){
        if(instance == null){
            synchronized (BaseReq.class){
                instance = new JokeReq();
            }
        }
        return instance;
    }

    public Observable<JokeRsp<JokeData>> newTxt(int page, int pageSize){
        return jokeApi.newTxt(JokeApi.AppKey,page,pageSize);
    }

    public Observable<JokeRsp<JokeData>> newPic(int page, int pageSize){
        return jokeApi.newPic(JokeApi.AppKey,page,pageSize);
    }

    @Override
    protected String baseUrl() {
        return JokeApi.BASE_URL;
    }
}
