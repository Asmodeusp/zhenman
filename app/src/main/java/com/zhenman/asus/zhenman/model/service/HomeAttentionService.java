package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface HomeAttentionService {
    //关注用户的作品列表
    @GET(Urls.USER_FOLLOW_WORKS_LIST)
    Observable<HomeAttentionBean> GetHomeAttentionBean(@QueryMap Map<String, String> params);
    //UGC点赞
    @FormUrlEncoded
    @POST(Urls.UGCFABULOUS)
    Observable<UgcFabulousBean> GetUgcFabulousBean(@FieldMap Map<String, String> params);
    //Pgc点赞(收藏)
    @FormUrlEncoded
    @POST(Urls.PGC_COLLECTION)
    Observable<PgcCollectionBean> GetPgcCollectionBean(@FieldMap Map<String, String> params);
    //关注主题
    @FormUrlEncoded
    @POST(Urls.ATTENTION_THEME)
    Observable<ThemeAttentionBean> GetThemeAttentionBean(@FieldMap Map<String ,String > parmaMap);
}