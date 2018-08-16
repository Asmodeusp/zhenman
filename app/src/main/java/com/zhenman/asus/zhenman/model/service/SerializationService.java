package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.SerializationBean;
import com.zhenman.asus.zhenman.model.bean.SerializationLatelyBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface SerializationService {
    //连载热门推荐
    @GET(Urls.SERIALIZATION_HOT)
    Observable<SerializationBean> GetSerializationBean(@QueryMap Map<String, String> params);
    //连载最近更新
    @GET(Urls.SERIALIZATION_LATELY)
    Observable<SerializationLatelyBean> GetSerializationLatelyBean(@QueryMap Map<String, String> params);
}
