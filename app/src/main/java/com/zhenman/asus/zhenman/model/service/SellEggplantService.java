package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;
import com.zhenman.asus.zhenman.model.bean.WeiXinTiXianBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SellEggplantService {
//    茄子数量
    @GET(Urls.SELL_EGGPLANT)
    Observable<SellEggplantBean> getSellEggplant();
//    微信提现
    @FormUrlEncoded
    @POST(Urls.WEIXIN_TIXIAN)
    Observable<WeiXinTiXianBean> getWeiXinTixian(@FieldMap Map<String,String> paramMap);
}
