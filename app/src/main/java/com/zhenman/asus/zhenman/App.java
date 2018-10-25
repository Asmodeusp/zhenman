package com.zhenman.asus.zhenman;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.zhenman.asus.zhenman.utils.umeng.UMengHelp;
import com.zhenman.asus.zhenman.view.ui.MyRefreshAnimHeader;
import com.zhy.autolayout.config.AutoLayoutConifg;

public class App extends Application {
    public static Context context;
    public static Activity AppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        UMengHelp.init(this);



    }
    //设置全局的下拉刷新样式
    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @SuppressLint("ResourceAsColor")
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout refreshLayout) {
                MyRefreshAnimHeader myRefreshAnimHeader = new MyRefreshAnimHeader(context);
                myRefreshAnimHeader.setPrimaryColors(R.color.h1);
                return myRefreshAnimHeader;
            }
        });
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}