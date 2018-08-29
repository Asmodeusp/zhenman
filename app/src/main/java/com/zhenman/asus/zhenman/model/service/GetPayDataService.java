package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetPayDataService {
//    GET_PAY_DATA="userOrder/getPaySignByAli?orderSn=ZM991535076014567";
    @GET(Urls.GET_PAY_DATA)
    Observable <GetPayDataBean> getPayData(@Query("orderSn") String orderSn);
}
