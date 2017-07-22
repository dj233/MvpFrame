package com.nbt.uitls;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class AppUtils {
    
    /**
     * 获取Meta-Data
     * @param context
     * @return
     */
    public static Bundle getMetaSet(Context context){
        Bundle bundle = null;
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            bundle = info.metaData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bundle;
    }
    
    /**
     * 获取Meta-Data值
     * @param context
     * @param key
     * @return
     */
    public static String getMetaSetStr(Context context, String key){
        String val = null;
        Bundle bundle = getMetaSet(context);
        val = bundle.getString(key);
        return val;
    }
    
    public static String getUmengAppKey(Context context){
        return getMetaSetStr(context, "UMENG_APPKEY");
    }
    
    public static String getUmengChannel(Context context){
        return getMetaSetStr(context, "UMENG_CHANNEL");
    }
    
    public static String getAdjustToken(Context context){
        return getMetaSetStr(context, "ADJUST_TOKEN");
    }
    
    public static String getGATrackingId(Context context){
        return getMetaSetStr(context, "GA_TRACKING_ID");
    }
}
