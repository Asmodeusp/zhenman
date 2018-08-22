package com.zhenman.asus.zhenman;

import android.app.Activity;
import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.zhy.autolayout.config.AutoLayoutConifg;

public class App extends Application {
    public static Activity context;

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();







       UMConfigure.init(this, "5b7a8abbb27b0a604f000085", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
//       微信登陆
        PlatformConfig.setWeixin("wx658d27e48aa3a824", "ef7d640e5a70604e4fd857e3d7a9b210 ");
//        新浪微博
        PlatformConfig.setSinaWeibo("3291048097", "7112b7d84d5734839c4eb126ebdb4200", "https://sns.whalecloud.com/sina2/callback");
//        QQAppId     AppKey
        PlatformConfig.setQQZone("1107229352", "K8M5rfupOFe0VSzw");
        UMConfigure.setLogEnabled(true);
       /*  UMShareAPI.get(this);
        Config.DEBUG = true;
        QueuedWork.isUseThreadPool = false;
        //三方获取用户资料时是否每次都要进行授权
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(this).setShareConfig(config);
//        微信App ID    AppSecret
        PlatformConfig.setWeixin("wx658d27e48aa3a824", "ef7d640e5a70604e4fd857e3d7a9b210 ");
//        QQAppId     AppKey
        PlatformConfig.setQQZone("1107229352", "K8M5rfupOFe0VSzw");
        PlatformConfig.setSinaWeibo("3291048097", "7112b7d84d5734839c4eb126ebdb4200", "https://sns.whalecloud.com/sina2/callback");
*/
    }
}