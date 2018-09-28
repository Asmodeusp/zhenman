package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.GetMyDataBean;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MySelfService {
    //    个人资料头部信息
    @GET(Urls.HEAD_DATA)
    Observable<HomePageHeadBean> getMySelfHeadData(@QueryMap Map<String, String> paramMap);

    //    得到个人资料
    @GET(Urls.GET_MYDATA)
    Observable<GetMyDataBean> getMyDataBean(@Query("oauthId") String oauthId);
}
