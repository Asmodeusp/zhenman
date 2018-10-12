package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface MyAttentionUserService {
    @GET(Urls.USER_ATTENTION)//关注的用户列表
    Observable<MyAttentionUserBean> getMyAttentionUser(@QueryMap Map<String,String> paramMap);
    @FormUrlEncoded//关注用户
    @POST(Urls.ATTENTION_USER)
    Observable<AttentionMyFansBean> getAttentionUser(@FieldMap Map<String,String> paramMap);
}
