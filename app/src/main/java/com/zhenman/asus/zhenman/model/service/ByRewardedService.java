package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ByRewardedBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ByRewardedService {
    @GET(Urls.BY_REWARDED)
    Observable<ByRewardedBean> getByRewarded(@QueryMap Map<String,String> paramMap);
}
