package com.nabt.cook;

import android.app.Application;

import com.nabt.cook.dao.DbMaster;

/**
 * Created by 14K on 2017/7/25.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DbMaster.$().init(this);
    }
}
