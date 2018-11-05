package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ByLikeBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ByLikeService {
    @GET(Urls.BY_LIKE)//被点赞列表
    Observable<ByLikeBean> getByLikeBean(@QueryMap Map<String,String> paramMap);
}
