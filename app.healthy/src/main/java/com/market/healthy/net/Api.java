package com.market.healthy.net;

import com.market.healthy.entity.Cate;
import com.market.healthy.entity.Detail;
import com.market.healthy.entity.Info;
import com.market.healthy.entity.ListData;
import com.market.healthy.entity.Rsp;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    String URL = "http://japi.juhe.cn/";
    String AppKey = "0eaafec239ac29adb09f2c0ad08f90cc";

    @GET("/health_knowledge/categoryList")
    Observable<Rsp<List<Cate>>> cateList(@Query("key") String appKey);

    @GET("/health_knowledge/infoList")
    Observable<Rsp<ListData<Info>>> infoList(@Query("key") String appKey,@Query("id") String cateId,@Query("page") String page,@Query("page") String limit);

    @GET("/health_knowledge/infoDetail")
    Observable<Rsp<Detail>> detail(@Query("key") String appKey,@Query("id") String infoId);

    @GET("/health_knowledge/infoNews")
    Observable<Rsp<ListData<Detail>>> newInfoList(@Query("key") String appKey);
}
