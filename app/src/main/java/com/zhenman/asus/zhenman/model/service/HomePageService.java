package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface HomePageService {
    @GET(Urls.HEAD_DATA)//头部信息
    Observable<HomePageHeadBean> getHomePageHeadData( @QueryMap Map<String,String> paramMap);
    @FormUrlEncoded//关注用户
    @POST(Urls.ATTENTION_USER)
    Observable<AttentionMyFansBean> getAttentionUser(@FieldMap Map<String,String> paramMap);
    //订单列表
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

}
