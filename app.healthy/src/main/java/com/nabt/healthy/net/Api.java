package com.nabt.healthy.net;

import com.nabt.healthy.entity.Cate;
import com.nabt.healthy.entity.Detail;
import com.nabt.healthy.entity.Info;
import com.nabt.healthy.entity.ListData;
import com.nabt.healthy.entity.Rsp;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    String URL = "http://japi.juhe.cn/";
    String AppKey = "e445226d0713ab1f219ab161a0b8aa5a";

    @GET("/health_knowledge/categoryList")
    Observable<Rsp<List<Cate>>> cateList(@Query("key") String appKey);

    @GET("/health_knowledge/infoList")
    Observable<Rsp<ListData<Info>>> infoList(@Query("key") String appKey,@Query("id") String cateId,@Query("page") String page,@Query("page") String limit);

    @GET("/health_knowledge/infoDetail")
    Observable<Rsp<Detail>> detail(@Query("key") String appKey,@Query("id") String infoId);

    @GET("/health_knowledge/infoNews")
    Observable<Rsp<ListData<Detail>>> newInfoList(@Query("key") String appKey);
}
