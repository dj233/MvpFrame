package com.nabt.healthy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;

import com.dao.wrapper.DbMaster;
import com.nabt.healthy.utils.AppUtils;
import com.umeng.analytics.MobclickAgent;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(mCallback);
        initUmengConfig();
        DbMaster.$().init(this);
    }

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
