package com.nbt.net;

import lib.data.BaseReq;
import rx.Observable;

public class JokeReq extends BaseReq {
    private static final String AppKey = "c400a0c176c41a0ed0bd33839eeedc70";
    private JokeApi jokeApi;
    private static JokeReq instance;

    private JokeReq(){
        jokeApi = mRetrofit.create(JokeApi.class);
    }

    public static JokeReq instance(){
        if(instance == null){
            synchronized (BaseReq.class){
                instance = new JokeReq();
            }
        }
        return instance;
    }

    public Observable<JokeRsp> newTxt(int page, int pageSize){
        return jokeApi.newTxt(AppKey,page,pageSize);
    }

    public Observable<JokeRsp> newPic(int page, int pageSize){
        return jokeApi.newPic(AppKey,page,pageSize);
    }
}
