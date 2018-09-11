package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.PurchaseHistoryBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

public interface PurchaseHistoryService {
//    购买记录
    @GET(Urls.PURCHASE_HISTORY)
    Observable<PurchaseHistoryBean> getPurchaseHistoryBean(@QueryMap Map<String,String> paramMap);
}
