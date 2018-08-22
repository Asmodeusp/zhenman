package com.zhenman.asus.zhenman.view.login.qqlogin;


import android.app.Activity;
import android.util.Log;
import android.widget.Toast;


import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class UMSharePlatform {

    public static UMSharePlatform umSharePlatform;
    public static UMSharePlatform getImstance(){
        if (umSharePlatform==null){
            umSharePlatform=new UMSharePlatform();
        }
        return umSharePlatform;
    }

    public void shareText(Activity activity,SHARE_MEDIA platform) {
        new ShareAction(activity)
                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                .withText("hello")//分享内容
                .setCallback(umShareListener)//回调监听器
                .share();
    }
    public void shareImage(Activity activity){
        new ShareAction(activity)
                .withText("hello")
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(umShareListener)
                .open();
    }

    private UMShareListener umShareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
//            Toast.makeText(act,"成功 了",Toast.LENGTH_LONG).show()；
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
//            Toast.makeText(ShareDetailActivity.this,"失                                            败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
//            Toast.makeText(ShareDetailActivity.this,"取消                                          了",Toast.LENGTH_LONG).show();

        }
    };
}
