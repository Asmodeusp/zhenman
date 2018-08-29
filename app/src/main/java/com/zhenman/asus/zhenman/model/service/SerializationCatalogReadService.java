package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
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
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface SerializationCatalogReadService {
    //连载阅读
    @FormUrlEncoded
    @POST(Urls.SERIALIZATION_CATALOG_READ)
    Observable<SerializationCatalogReadBean> getSerializationCatalogReadBean(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);

    //连载章节
    @GET(Urls.SERIALIZATION_CATALOG)
    Observable<SerializationCatalogBean> getSerializationCatalogBean(@HeaderMap Map<String, String> headers, @QueryMap Map<String, String> params);


//    创建订单

    @FormUrlEncoded
    @POST(Urls.MAKE_ORDER)
    Observable<MakeOrderBean> getMakeOrderBean(@HeaderMap Map<String ,String> headMap, @FieldMap Map<String,String > map);
//得到订单号
    //    GET_PAY_DATA="userOrder/getPaySignByAli?orderSn=ZM991535076014567";
    @GET(Urls.GET_PAY_DATA)
    Observable <GetPayDataBean> getPayData(@Query("orderSn") String orderSn);
}
