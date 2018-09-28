package com.zhenman.asus.zhenman.utils;

import android.os.Build;
import android.util.Log;

import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private OkHttpClient okHttpClient;
    private static OkHttpUtils okHttpUtils;

    /**
     * 构造函数私有化
     */
    private OkHttpUtils() {
        Interceptor myLoggingInterceptor = getMyLoggingInterceptor();
//        Interceptor interceptor = getAddHeaderInterceptor();
//        Interceptor loggingInterceptor = getLoggingInterceptor();
//        Cache cache = getCache();
        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(myLoggingInterceptor)
//                .cache(cache)
                .build();
    }

    /**
     * 获取手动书写的日志拦截器对象
     *
     * @return
     */
    private Interceptor getMyLoggingInterceptor() {
        //创建拦截器对象
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //获取请求对象
                Request request = chain.request();
                //获取响应对象
                Response response = chain.proceed(request);
                //获取所有响应头
                Headers headers = response.headers();
                //便利所有响应头
                Set<String> names = headers.names();
                for (String name : names) {
                    Log.d("OkHttpUtils", name + " : " + headers.get(name));
                }
                //一定要将原有响应对象返回，不要去new。否则请求不到数据
                return response;
            }
        };
        return interceptor;
    }

    /**
     * 获取添加请求头的拦截器对象
     *
     * @return
     */
    private Interceptor getAddHeaderInterceptor() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //获取请求对象
                Request request = chain.request();
                //获取响应对象
                Response response = chain.proceed(request);
                //通过原有的Response对象获取 Response.Builder
                Response.Builder responseBuilder = response.newBuilder()
                        .header("os", "Android")
                        .header("accessToken",((String) SPUtils.get(App.context, SPKey.USER_TOKEN, "")))
                        .header("osVersion", Build.VERSION.RELEASE)
                        .header("version", "1.0.0")
                        .header("AppType", "TPOS")
                        .header("Accept", "application/json");
                //添加响应头
                Response newResponse = responseBuilder
                        //添加Cache-Control字段支持缓存
                        .addHeader("Cache-Control", "max-age=" + 60 * 60 * 12)
//                        .addHeader("key2", "value2")
                        .build();
                //将新获取的Response对象返回
                return newResponse;
            }
        };
//        Interceptor headerInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request originalRequest = chain.request();
//                Request.Builder requestBuilder = originalRequest.newBuilder()
//                        // Provide your custom header here
//                        .header("os", "Android")
//                        .header("accessToken",((String) SPUtils.get(App.context, SPKey.USER_TOKEN, "")))
//                        .header("osVersion", Build.VERSION.RELEASE)
//                        .header("version", "1.0.0")
//                        .header("AppType", "TPOS")
//                        .header("Accept", "application/json")
//                        .method(originalRequest.method(), originalRequest.body());
//                Request request = requestBuilder.build();
//                return chain.proceed(request);
//            }
//        };
        return headerInterceptor;
    }

    /**
     * 获取日志拦截器对象
     *
     * @return
     */
    private Interceptor getLoggingInterceptor() {
        //创建拦截器对象
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
        //设置打印信息    HEADERS为响应头  BODY为响应体   NONE为什么都不打印  BASIC为基本信息(响应头和响应体)
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    /**
     * 获取Cache对象
     *
     * @return
     */
    private Cache getCache() {
        // App.context.getCacheDir()获取App的dir目录   文件大小
        Cache cache = new Cache(App.context.getCacheDir(), 1024 * 1024 * 10);
        return cache;
    }

    /**
     * 提供一个公共的，静态的，返回值为当前类的本身的方法
     *
     * @return 本类对象
     */
    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }


    /**
     * 发送无参的get请求
     *
     * @param url      请求地址
     * @param callBack 请求的回调
     */
    public void doGet(String url, final MyNetworkCallBack callBack) {
        Request request = new Request.Builder()
                .url(Urls.BASE_URL+url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {

                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseStr = response.body().string();
                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(responseStr);
                    }
                });
            }
        });
    }

    /**
     * 发送同步的get请求
     *
     * @return 请求结果转为字符串
     */
    public String doGetTong(String url) {
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String responseStr = response.body().string();
            return responseStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 带参数的get请求
     *
     * @param url      请求地址
     * @param params   请求参数
     * @param callBack 请求的回调
     */
    public void doGet(String url, Map<String, String> params, final MyNetworkCallBack callBack) {
        if (!params.isEmpty() && params != null) {
            StringBuilder sbUrl = new StringBuilder(Urls.BASE_URL+url);
            sbUrl.append("?");
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                sbUrl.append(key).append("=").append(params.get(key)).append("&");
            }
            url = sbUrl.substring(0, sbUrl.length() - 1);
        }
        Request request = new Request.Builder()
                .url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {
                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e.getMessage());
                    }
                });
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseStr = response.body().string();
                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(responseStr);
                    }
                });
            }
        });
    }


    /**
     * 发送带请求头的get请求
     *
     * @param url      请求地址
     * @param headers  请求头
     * @param callBack 请求的回调
     */
    public void doGetHeader(String url, Map<String, String> headers, final MyNetworkCallBack callBack) {
        Request.Builder builder = new Request.Builder().url(Urls.BASE_URL+url);
        if (headers.isEmpty() && headers != null) {
            Set<String> keySet = headers.keySet();
            for (String key : keySet) {
                builder.addHeader(key, headers.get(key));
            }
        }
        Request request = builder.build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {
                //切换回主线程循环执行
                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String responseStr = response.body().string();

                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(responseStr);
                    }
                });
            }
        });
    }

    /**
     * 发送无参的post请求
     * 无参的post请求与get请求没有区别，完全可以当做无参的get请求处理
     * 就不写了，直接看无参的get请求即可
     *
     * @param url      请求地址
     * @param callBack 请求的回调
     */
    public void doPost(String url, MyNetworkCallBack callBack) {
        doGet(url, callBack);
    }

    /**
     * 发送同的post请求
     * 无参同步的post请求与同步get请求没有区别，完全可以当做无参同步的get请求处理
     * 就不写了，直接看无参同步的get请求即可
     *
     * @return 请求结果转为字符串
     */
    public String doPostTong(String url) {
        String request = doGetTong(url);
        return request;
    }


    /**
     * 发送有参的post请求
     *
     * @param url      请求地址
     * @param params   请求参数
     * @param callBack 请求的回调
     */
    public void doPost(String url, Map<String, String> params, final MyNetworkCallBack callBack) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params.isEmpty() && params != null) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                builder.add(key, params.get(key));
            }
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().post(formBody).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {
                //切换回主线程循环执行
                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String responseStr = response.body().string();

                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(responseStr);
                    }
                });
            }
        });
    }

    /**
     * 发送带请求头的post请求
     *
     * @param url      请求地址
     * @param headers  请求头信息
     * @param callBack 请求的回调
     */
    public void doPostHeader(String url, Map<String, String> headers, final MyNetworkCallBack callBack) {
        FormBody.Builder formBuilder = new FormBody.Builder();
        /**
         * 添加参数
         */
        FormBody formBody = formBuilder.build();
        Request.Builder builder = new Request.Builder().post(formBody);
        if (headers.isEmpty() && headers != null) {
            Set<String> keySet = headers.keySet();
            for (String key : keySet) {
                builder.addHeader(key, headers.get(key));
            }
        }
        Request request = builder.build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {
                //切换回主线程循环执行
                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String responseStr = response.body().string();

                App.AppContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(responseStr);
                    }
                });
            }
        });

    }
}
