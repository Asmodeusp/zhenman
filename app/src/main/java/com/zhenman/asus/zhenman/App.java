package com.zhenman.asus.zhenman;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.zhenman.asus.zhenman.utils.umeng.UMengHelp;
import com.zhy.autolayout.config.AutoLayoutConifg;

public class App extends Application {
    public static Activity context;

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        UMengHelp.init(this);


    }

}