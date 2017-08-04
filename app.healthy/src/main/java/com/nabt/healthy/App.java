package com.nabt.healthy;

import android.app.Application;

import com.dao.wrapper.DbMaster;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DbMaster.$().init(this);
    }
}
