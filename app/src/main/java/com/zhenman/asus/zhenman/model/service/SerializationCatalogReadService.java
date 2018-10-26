package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.PgcReadFabulousBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface SerializationCatalogReadService {
    //连载阅读
    @FormUrlEncoded
    @POST(Urls.SERIALIZATION_CATALOG_READ)
    Observable<SerializationCatalogReadBean> getSerializationCatalogReadBean(@FieldMap Map<String, String> params);

    //连载章节
    @GET(Urls.SERIALIZATION_CATALOG)
    Observable<SerializationCatalogBean> getSerializationCatalogBean(@QueryMap Map<String, String> params);  //连载章节

    //评论列表
    @GET(Urls.COMMENT_LIST)
    Observable<CommentListBean> getCommentListBean(@QueryMap Map<String, String> paramMap);

    //PGC评论点赞
    @FormUrlEncoded
    @POST(Urls.PGCFABULOUS)
    Observable<PgcReadFabulousBean> GetPGCReadFabulousBean(@FieldMap Map<String, String> params);


    //产品列表
    @GET(Urls.PRODUCT_LIST)
    Observable<ProductListBean> getProductList(@QueryMap Map<String, String> paramMap);

    //创建订单
    @FormUrlEncoded
    @POST(Urls.MAKE_ORDER)
    Observable<MakeOrderBean> getMakeOrderBean(@FieldMap Map<String, String> map);

    //创建微信订单
    @FormUrlEncoded
    @POST(Urls.MAKE_ORDER)
    Observable<MakeOrderBean> getWxMakeOrderBean(@FieldMap Map<String, String> map);

    //得到支付宝订单号
    //    GET_PAY_DATA="userOrder/getPaySignByAli?orderSn=ZM991535076014567";
    @GET(Urls.GET_PAY_DATA)
    Observable<GetPayDataBean> getPayData(@Query("orderSn") String orderSn);

    //    得到微信数据
    @GET(Urls.GET_WX_PAY_DATA)
    Observable<PayWeChatBean> getWXPayData(@Query("orderSn") String orderSn);

    //PGC收藏
    @FormUrlEncoded
    @POST(Urls.PGC_COLLECTION)
    Observable<PgcCollectionBean> GetPgcCollectionBean(@FieldMap Map<String, String> params);
}

