package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

public interface SerializationDetailsService {
    //连载详情
    @GET(Urls.SERIALIZATION_DETAILS)
    Observable<SerializationDetailsBean> GetSerializationDetailsBean(@HeaderMap Map<String, String> headers, @QueryMap Map<String, String> params);

    //连载章节
    @GET(Urls.SERIALIZATION_CATALOG)
    Observable<SerializationCatalogBean> GetSerializationCatalogBean(@HeaderMap Map<String, String> headers, @QueryMap Map<String, String> params);
}
