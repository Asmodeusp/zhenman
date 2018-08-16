package com.zhenman.asus.zhenman;

import android.app.Activity;
import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

public class App extends Application {
    public static Activity context;

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}