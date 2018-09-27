package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
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
}
