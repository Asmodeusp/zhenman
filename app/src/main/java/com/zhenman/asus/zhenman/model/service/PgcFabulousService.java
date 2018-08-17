package com.zhenman.asus.zhenman.model.service;

import android.database.Observable;

import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.UserBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface PgcFabulousService {
    //PGC点赞
    @FormUrlEncoded
    @POST(Urls.PGCFABULOUS)
    Observable<PgcFabulousBean> GetPgcFabulousBean(@HeaderMap Map<String,String >Heards,@FieldMap Map<String, String> params);
}
