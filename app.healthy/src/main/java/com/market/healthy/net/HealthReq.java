package com.market.healthy.net;

import com.market.healthy.entity.Cate;
import com.market.healthy.entity.Detail;
import com.market.healthy.entity.Info;
import com.market.healthy.entity.ListData;
import com.market.healthy.entity.Rsp;

import java.util.List;

import lib.data.BaseReq;
import rx.Observable;

public class HealthReq extends BaseReq {

    private static HealthReq _inst;
    private Api api;

    @Override
    protected String baseUrl() {
        return Api.URL;
    }

    private HealthReq(){
        api = mRetrofit.create(Api.class);
    }

    public static HealthReq $(){
        if(_inst == null){
            synchronized (HealthReq.class){
                _inst = new HealthReq();
            }
        }
        return _inst;
    }

    public Observable<Rsp<List<Cate>>> listCate(){
        return api.cateList(Api.AppKey);
    }

    public Observable<Rsp<ListData<Info>>> listInfo(String cateId,String page,String pageSize){
        return api.infoList(Api.AppKey,cateId,page,pageSize);
    }

    public Observable<Rsp<ListData<Detail>>> listNewInfo(){
        return api.newInfoList(Api.AppKey);
    }

    public Observable<Rsp<Detail>> detail(String infoId){
        return api.detail(Api.AppKey,infoId);
    }
}
