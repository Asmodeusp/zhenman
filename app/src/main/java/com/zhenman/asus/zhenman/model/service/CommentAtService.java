package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface CommentAtService {
    //用户关注列表
    @GET(Urls.USER_ATTENTION)//关注的用户列表
    Observable<MyAttentionUserBean> getMyAttentionUser(@QueryMap Map<String,String> paramMap);
    //演员列表
    //连载详情
    @GET(Urls.SERIALIZATION_DETAILS)
    Observable<SerializationDetailsBean> GetSerializationDetailsBean(@QueryMap Map<String, String> params);
}
