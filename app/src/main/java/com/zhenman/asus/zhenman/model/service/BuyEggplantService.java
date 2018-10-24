package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface BuyEggplantService {
    //产品列表
    @GET(Urls.PRODUCT_LIST)
    Observable<ProductListBean> getProductList(@QueryMap Map<String, String> paramMap);
}
