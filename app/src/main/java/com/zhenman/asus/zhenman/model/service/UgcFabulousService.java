package com.zhenman.asus.zhenman.model.service;

import io.reactivex.Observable;

import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface UgcFabulousService {
    //UGC点赞
    @FormUrlEncoded
    @POST(Urls.UGCFABULOUS)
    Observable<UgcFabulousBean> GetUgcFabulousBean(@HeaderMap Map<String,String > Heards, @FieldMap Map<String, String> params);
}
