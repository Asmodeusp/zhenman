package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

public interface HomeHotService {
    //主页热门
    @GET(Urls.HOME_HOT)
    Observable<HomeHotBean> GetHotBean(@HeaderMap Map<String, String> headers, @QueryMap Map<String,String> params);
}

