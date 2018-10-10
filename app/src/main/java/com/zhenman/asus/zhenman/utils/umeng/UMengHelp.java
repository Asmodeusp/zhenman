package com.zhenman.asus.zhenman.utils.umeng;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/**
 * 封装关于友盟的分享与登录
 */
public class UMengHelp {
    //友盟的AppKey
    private static final String UM_APP_KEY = "5b7a8abbb27b0a604f000085";
    //微信的appid
    private static final String WEI_XIN_APP_ID = "wx658d27e48aa3a824";
    //微信的appkey
    private static final String WEI_XIN_APP_KEY = "ef7d640e5a70604e4fd857e3d7a9b210";
    //qq的AppId
    private static final String QQ_APP_ID = "1107229352";
    //qq的AppKey
    private static final String QQ_APP_KEY = "K8M5rfupOFe0VSzw";
    //新浪AppId1406219590
    private static final String WEI_BO_APP_ID = "3291048097";
    //新浪AppKey
    private static final String WEI_BO_APP_KEY = "7112b7d84d5734839c4eb126ebdb4200";
    //    给定登陆方式
    private static String TYPE;

    /**
     * 初始化友盟
     */
    public static void init(Context context) {
//        打印全局log
        UMConfigure.setLogEnabled(true);
        UMConfigure.init(context, UM_APP_KEY, "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");//
        // 将该app注册到微信
//        api.registerApp("wx658d27e48aa3a824");
        PayReq request = new PayReq();
        PlatformConfig.setWeixin(WEI_XIN_APP_ID, WEI_XIN_APP_KEY);
        PlatformConfig.setQQZone(QQ_APP_ID, QQ_APP_KEY);
        PlatformConfig.setSinaWeibo(WEI_BO_APP_ID, WEI_BO_APP_KEY, "https://sns.whalecloud.com/sina2/callback");
    }

    /**
     * 申请分享权限
     *
     * @param activity
     * @param requestCode   申请权限的请求码
     * @param shareCallBack 分享权限的回调
     */
    public static void applySharePermission(Activity activity, int requestCode, ShareCallBack shareCallBack) {
        //判断SDK版本号
        if (Build.VERSION.SDK_INT >= 23) {
            //要申请的所有权限
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            //申请权限
            ActivityCompat.requestPermissions(activity, mPermissionList, requestCode);
        } else {
            //SDK版本号小于23直接分享
            shareCallBack.shareOrLogin();
        }
    }

    /**
     * 申请分享权限的回调
     *
     * @param context
     * @param grantResults
     * @param shareCallBack
     */
    public static void responseSharePermission(Activity context, int[] grantResults, int requestCode, ShareCallBack shareCallBack) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //有权限直接分享
            shareCallBack.shareOrLogin();
        } else {
            Toast.makeText(context, "您求权限未授权", Toast.LENGTH_SHORT).show();
            UMengHelp.applySharePermission(context, requestCode, shareCallBack);
        }
    }

    /**
     * 分享纯文本
     *
     * @param activity
     * @param platform     分享到的平台
     * @param shareContent
     * @param isPanel      是否带面板     true带面板  false不带面板
     */
    public static void shareText(final Activity activity, SHARE_MEDIA platform, String shareContent, boolean isPanel) {
        ShareAction shareAction = new ShareAction(activity)
                .withText(shareContent)
                .setCallback(new UMShareListener() {
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
                        Toast.makeText(activity, "成功了", Toast.LENGTH_LONG).show();
                    }

                    /**
                     * @descrption 分享失败的回调
                     * @param platform 平台类型
                     * @param t 错误原因
                     */
                    @Override
                    public void onError(SHARE_MEDIA platform, Throwable t) {
                        Toast.makeText(activity, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    /**
                     * @descrption 分享取消的回调
                     * @param platform 平台类型
                     */
                    @Override
                    public void onCancel(SHARE_MEDIA platform) {
                        Toast.makeText(activity, "取消了", Toast.LENGTH_LONG).show();

                    }
                });
        if (isPanel) {
            shareAction.setDisplayList(platform);//分享平台
            //带面板
            shareAction.open();
        } else {
            shareAction.setPlatform(platform);//分享平台
            //不带面板
            shareAction.share();
        }

    }

    /**
     * 分享带面板图片
     *
     * @param activity
     * @param imageUrl 图片的url地址
     */
    public static void shareImg(final Activity activity, String imageUrl, boolean isPanel) {

        UMImage image = new UMImage(activity, imageUrl);//网络图片
        ShareAction shareAction = new ShareAction(activity)
                .withMedia(image)
                .setCallback(new UMShareListener() {
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
                        Toast.makeText(activity, "成功了", Toast.LENGTH_LONG).show();
                    }

                    /**
                     * @descrption 分享失败的回调
                     * @param platform 平台类型
                     * @param t 错误原因
                     */
                    @Override
                    public void onError(SHARE_MEDIA platform, Throwable t) {
                        Toast.makeText(activity, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    /**
                     * @descrption 分享取消的回调
                     * @param platform 平台类型
                     */
                    @Override
                    public void onCancel(SHARE_MEDIA platform) {
                        Toast.makeText(activity, "取消了", Toast.LENGTH_LONG).show();

                    }
                });
        if (isPanel) {
            shareAction.setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN);//分享平台
            //带面板
            shareAction.open();
        }
    }


    /**
     * 分享带面板链接
     *
     * @param activity
     * @param platform    分享到的平台
     * @param WebUrl      分享的链接
     * @param title       分享链接的标题
     * @param imageUrl    分享链接的缩略图
     * @param description 分享的链接的简介
     * @param isPanel     是否带面板
     */
    public static void shareWeb(final Activity activity, String WebUrl,
                                String title, String description, String imageUrl,
                                int imageID, SHARE_MEDIA platform, boolean isPanel) {
        UMWeb web = new UMWeb(WebUrl);//连接地址
        web.setTitle(title);//标题
        web.setDescription(description);//描述
        if (TextUtils.isEmpty(imageUrl)) {
            web.setThumb(new UMImage(activity, imageID));  //本地缩略图
        } else {
            web.setThumb(new UMImage(activity, imageUrl));  //网络缩略图
        }
        ShareAction shareAction = new ShareAction(activity)
                .setPlatform(platform)
                .withMedia(web)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(final SHARE_MEDIA share_media) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (share_media.name().equals("WEIXIN_FAVORITE")) {
                                    Toast.makeText(activity, share_media + " 收藏成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(activity, share_media + " 分享成功", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }

                    @Override
                    public void onError(final SHARE_MEDIA share_media, final Throwable throwable) {
                        if (throwable != null) {
                            Log.d("throw", "throw:" + throwable.getMessage());
                        }
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(activity, share_media + " 分享失败", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                    @Override
                    public void onCancel(final SHARE_MEDIA share_media) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(activity, share_media + " 分享取消", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
        if (isPanel) {
            shareAction.setDisplayList(platform);//分享平台
            //带面板
            shareAction.open();
        } else {
            shareAction.setPlatform(platform);//分享平台
            //不带面板
            shareAction.share();
        }
    }

    /**
     * 第三方登录
     *
     * @param context
     */
    public static void login(final Activity context, SHARE_MEDIA platform, UMAuthListener listener) {
        UMShareAPI.get(context).getPlatformInfo(context, platform, listener);
    }

    public static void login(final Activity context, SHARE_MEDIA platform) {
        UMShareAPI.get(context).getPlatformInfo(context, platform, null);
    }
}
