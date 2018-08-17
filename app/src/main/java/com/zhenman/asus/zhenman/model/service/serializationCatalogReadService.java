package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface serializationCatalogReadService {
    //连载阅读
    @FormUrlEncoded
    @POST(Urls.SERIALIZATION_CATALOG_READ)
    Observable<SerializationCatalogReadBean> GetSerializationCatalogReadBean(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    //连载章节
    @GET(Urls.SERIALIZATION_CATALOG)
    Observable<SerializationCatalogBean> GetSerializationCatalogBean(@HeaderMap Map<String, String> headers, @QueryMap Map<String, String> params);

}
