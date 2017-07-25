package com.nabt.cook.net;

import com.nabt.cook.dao.entity.Book;
import com.nabt.cook.net.po.Data;
import com.nabt.cook.net.po.Result;
import com.nabt.cook.net.po.Tab;

import java.util.List;

import lib.data.BaseReq;
import rx.Observable;

/**
 * Created by 14K on 2017/7/26.
 */

public class Req extends BaseReq {

    private Api api;
    private static Req _$;

    private Req() {
        api = mRetrofit.create(Api.class);
    }

    public static Req $(){
        if(_$ == null){
            synchronized (Req.class){
                _$ = new Req();
            }
        }
        return _$;
    }

    @Override
    protected String baseUrl() {
        return Api.BaseUrl;
    }

    public Observable<Result<List<Tab>>> tabs(){
        return api.tabs(Api.AppKey);
    }

    public Observable<Result<Data<Book>>> byType(String typeId,int page,int pageSize){
        return api.booksByType(Api.AppKey,typeId,page,pageSize);
    }

    public Observable<Result<Data<Book>>> byKeyword(String keyword,int page,int pageSize){
        return api.booksByKeyword(Api.AppKey,keyword,page,pageSize);
    }


}
