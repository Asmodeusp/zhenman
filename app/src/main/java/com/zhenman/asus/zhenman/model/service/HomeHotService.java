package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface HomeHotService {
    //主页热门
    @GET(Urls.HOME_HOT)
    Observable<HomeHotBean> GetHotBean(@QueryMap Map<String, String> params);

    //UGC点赞
    @FormUrlEncoded
    @POST(Urls.UGCFABULOUS)
    Observable<UgcFabulousBean> GetUgcFabulousBean(@FieldMap Map<String, String> params);
    //关注
    @FormUrlEncoded
    @POST(Urls.INSERT_USER_FOLLOW)
    Observable<FollowBean> GetFollowBean(@FieldMap Map<String, String> params);
    //Pgc点赞(收藏)
    @FormUrlEncoded
    @POST(Urls.PGC_COLLECTION)
    Observable<PgcCollectionBean> GetPgcCollectionBean(@FieldMap Map<String, String> params);

}

