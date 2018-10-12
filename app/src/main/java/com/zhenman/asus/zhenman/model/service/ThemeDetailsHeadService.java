package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.ThemeDetailHeadBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ThemeDetailsHeadService {
//    获取主题详情头部信息
    @GET(Urls.THEME_DETAIL_HEAD)
    Observable<ThemeDetailHeadBean> getThemeDetailHead(@Query("subjectId") String subjectId);
    //    关注主题
    @FormUrlEncoded
    @POST(Urls.ATTENTION_THEME)
    Observable<ThemeAttentionBean> AttentionThemeData(@FieldMap Map<String ,String > parmaMap);
}
