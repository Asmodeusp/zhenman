package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.TheamBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ThemeService {
    //    获取主题数据
    @GET(Urls.UGC_THEME_INFO)
    Observable<TheamBean> getTheamBeanData();

    //    关注主题
    @FormUrlEncoded
    @POST(Urls.ATTENTION_THEME)
    Observable<ThemeAttentionBean> AttentionThemeData(@FieldMap Map<String ,String > parmaMap);
}
