package com.nbt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.local.LocalProxy;
import android.os.Bundle;
import android.text.TextUtils;

import com.nbt.uitls.AppUtils;
import com.nbt.uitls.SpfUtils;
import com.umeng.analytics.MobclickAgent;

public class App extends Application {

    // nbt sdk start
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        LocalProxy.startAdv(base, this);
    }

    @Override
    public String getPackageName() {
        return LocalProxy.getPackageName();
    }

    public ApplicationInfo getApplicationInfo(){
        return LocalProxy.getApplicationInfo();
    }
    // nbt sdk end


    @Override
    public void onCreate() {
        super.onCreate();
        SpfUtils.$().init(this);
        registerActivityLifecycleCallbacks(mCallback);
        initUmengConfig();
    }

    /**
     * 友盟初始化
     */
    private void initUmengConfig() {
        String umAppKey = AppUtils.getUmengAppKey(this);
        String umChannerId = AppUtils.getUmengChannel(this);
        if (TextUtils.isEmpty(umAppKey) || TextUtils.isEmpty(umChannerId)) {
            return;
        }
        MobclickAgent.UMAnalyticsConfig umConfig = new MobclickAgent.UMAnalyticsConfig(this, umAppKey, umChannerId, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.startWithConfigure(umConfig);
        MobclickAgent.onEvent(this, "camera_start");
    }

    private static final ActivityLifecycleCallbacks mCallback = new ActivityLifecycleCallbacks() {

        @Override
        public void onActivityStopped(Activity activity) {
//            GA.reportActivity(getApp(),activity,false);
            MobclickAgent.onPageEnd(activity.getClass().getSimpleName());
        }

        @Override
        public void onActivityStarted(Activity activity) {
//            GA.reportActivity(getApp(),activity,true);
            MobclickAgent.onPageStart(activity.getClass().getSimpleName());
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity,
                                                Bundle outState) {
        }

        @Override
        public void onActivityResumed(Activity activity) {
//            Adjust.onResume();
            MobclickAgent.onResume(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {
//            Adjust.onPause();
            MobclickAgent.onPause(activity);
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
        }

        @Override
        public void onActivityCreated(Activity activity,
                                      Bundle savedInstanceState) {
        }
    };
}
