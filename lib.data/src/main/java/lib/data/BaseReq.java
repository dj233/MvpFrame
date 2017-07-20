package lib.data;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseReq {
    private static final String TAG = BaseReq.class.getSimpleName();
    private static final boolean NetLogOpen = true;

    private static final int DEFAULT_TIME_OUT = 30;
    private static final int DEFAULT_WRITE_TIME_OUT = 60;
    private static final int DEFAULT_READ_TIME_OUT = 60;

    protected Retrofit mRetrofit;

    protected BaseReq(){
        initRetrofit();
    }

    private void initRetrofit(){

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.writeTimeout(DEFAULT_WRITE_TIME_OUT,TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//读操作 超时时间

        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e(TAG,"OkHttp====Message:"+message);
            }
        });
        loggingInterceptor.setLevel(level);
        if(NetLogOpen) {
            builder.addInterceptor(loggingInterceptor);
        }
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl())
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    protected abstract String baseUrl();
}
