package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

public interface HomePageService {
    @GET(Urls.HEAD_DATA)
    Observable<HomePageHeadBean> getHomePageHeadData( @QueryMap Map<String,String> paramMap);

}
