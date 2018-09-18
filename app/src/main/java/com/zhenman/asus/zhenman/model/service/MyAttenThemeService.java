package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.MyAttenThemeBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface MyAttenThemeService {
//    关注列表
    @GET(Urls.MY_ATTENTION_THEME)
    Observable<MyAttenThemeBean> getMyAttenThemeBean(@QueryMap Map<String,String> paramMap);
    //    关注主题
    @FormUrlEncoded
    @POST(Urls.ATTENTION_THEME)
    Observable<ThemeAttentionBean> AttentionThemeData(@FieldMap Map<String ,String > parmaMap);
}
