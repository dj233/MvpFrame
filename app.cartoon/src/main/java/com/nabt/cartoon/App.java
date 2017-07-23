package com.nabt.cartoon;

import android.app.Application;

import com.nabt.db.wrapper.DbMaster;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbMaster.$().init(this);
    }
}
