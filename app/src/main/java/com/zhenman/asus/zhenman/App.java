package com.zhenman.asus.zhenman;

import android.app.Activity;
import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.common.QueuedWork;
import com.zhy.autolayout.config.AutoLayoutConifg;

public class App extends Application {
    public static Activity context;

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();


        UMConfigure.init(this, "5b7a8abbb27b0a604f000085", "Shutang", UMConfigure.DEVICE_TYPE_PHONE, "");//最后一个参数为推送时需要用到的
        UMShareAPI.get(this);
        Config.DEBUG = true;
        QueuedWork.isUseThreadPool = false;
        //三方获取用户资料时是否每次都要进行授权
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(this).setShareConfig(config);
//        微信App ID    AppSecret
        PlatformConfig.setWeixin("wx658d27e48aa3a824", "ef7d640e5a70604e4fd857e3d7a9b210");
//        QQAppId     AppKey
        PlatformConfig.setQQZone("1107229352", "K8M5rfupOFe0VSzw");
//        PlatformConfig.setSinaWeibo("3291048097", "7112b7d84d5734839c4eb126ebdb4200", "新浪微博的回调url");

    }
}