package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ThemeFeaturedBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ThemeFeaturedSquareService {
    @GET(Urls.THEME_FEATURED)
    Observable<ThemeFeaturedBean> getThemeFeaturedSquareData(@QueryMap Map<String, String> paramMap);
}
