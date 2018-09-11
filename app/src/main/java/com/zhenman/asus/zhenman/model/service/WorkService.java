package com.zhenman.asus.zhenman.model.service;
import com.zhenman.asus.zhenman.model.bean.HomeHotUgcCommentBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

public interface WorkService {
    //主页热门
    @GET(Urls.UGC_COMMENT_BYCOMICID)
    Observable<HomeHotUgcCommentBean> GetHomeHotUgcCommentBean( @QueryMap Map<String,String> params);
}
