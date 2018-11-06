package com.zhenman.asus.zhenman.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.model.service.HomeHotService;
import com.zhenman.asus.zhenman.model.service.LoginService;
import com.zhenman.asus.zhenman.model.service.RegisterVerificationCodeService;
import com.zhenman.asus.zhenman.model.service.SerializationDetailsService;
import com.zhenman.asus.zhenman.model.service.SerializationService;
import com.zhenman.asus.zhenman.model.service.SetPasswordService;
import com.zhenman.asus.zhenman.model.service.WorkDetailsCommentService;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Retrofit工具类
 */
public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;

    private RetrofitUtils() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(addHeaderInterceptor());
//        错误重连
        builder.connectTimeout(30, TimeUnit.SECONDS).
                readTimeout(30, TimeUnit.SECONDS).
                writeTimeout(30, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        OkHttpClient client = builder.build();
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(Urls.BASE_URL)
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }



    /**
     * 设置请求头
     */
    private static Interceptor addHeaderInterceptor() {

        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        //添加请求头  判断IOS 还是 Android
                        .header("os", "Android")
                        .header("accessToken",((String)SPUtils.get(App.context, SPKey.USER_TOKEN, "")))
//                        .header("accessToken","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1NDA4ODMzMzIsInN1YiI6IntcInVzZXJJZFwiOjQwNixcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiRTk1NjlENkRCMDREQUJFNzc0NjE0RkI1OTFBQTkxMjRcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4zLjBcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU3MjQxOTMzMn0.jJT8sOS4JtOJQ9W0RFYGf-zNIfeGUKzv_fUUc78JqqA")
                        //当前手机版本号
                        .header("osVersion", Build.VERSION.RELEASE)
                        //当前项目版本号
                        .header("version", "1.0.0")
                        //添加设备唯一标识
                        .header("deviceId",Build.FINGERPRINT)
                        //添加手机设备名
                        .header("deviceModel",Build.PRODUCT)
                        .header("AppType", "TPOS")
                        .header("Accept", "application/json")
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };

        return headerInterceptor;
    }

    /**
     * 设置缓存
     */
    private static Interceptor addCacheInterceptor() {
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                if (!isNetworkAvailable(App.context)) {
                    request = request.newBuilder()

                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();

                }
                Response response = chain.proceed(request);
                if (isNetworkAvailable(App.context)) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Retrofit")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("nyn")
                            .build();
                    Toast.makeText(App.context, "网络连接错误，请检查网络！", Toast.LENGTH_SHORT).show();
                }
                return response;
            }
        };
        return cacheInterceptor;
    }

    /**
     * 判断网络
     */
    public static boolean isNetworkAvailable(Context ct) {
        Context context = ct.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public LoginService getLoginService() {
        return retrofit.create(LoginService.class);
    }

    public RegisterVerificationCodeService getRegisterVerificationCodeService() {
        return retrofit.create(RegisterVerificationCodeService.class);
    }

    public SetPasswordService getSetPasswordService() {
        return retrofit.create(SetPasswordService.class);
    }

    public HomeHotService getHomeHotService() {
        return retrofit.create(HomeHotService.class);
    }

    public SerializationService getSerializationService() {
        return retrofit.create(SerializationService.class);
    }

    public SerializationDetailsService getSerializationDetailsService() {
        return retrofit.create(SerializationDetailsService.class);
    }

    public WorkDetailsCommentService getWorkDetailsCommentService() {
        return retrofit.create(WorkDetailsCommentService.class);
    }

    /**
     * 获取Service对象
     *
     * @param tClass 要获取Service的class对象
     * @param <T>    Service对象的类型
     * @return Service对象
     */
    public <T> T getService(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}

