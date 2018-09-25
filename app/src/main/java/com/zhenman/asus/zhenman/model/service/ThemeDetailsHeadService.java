package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ThemeDetailHeadBean;
import com.zhenman.asus.zhenman.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ThemeDetailsHeadService {
//    获取主题详情头部信息
    @GET(Urls.THEME_DETAIL_HEAD)
    Observable<ThemeDetailHeadBean> getThemeDetailHead(@Query("subjectId") String subjectId);
}
