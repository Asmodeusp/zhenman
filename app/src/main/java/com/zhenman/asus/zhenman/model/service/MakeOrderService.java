package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface MakeOrderService {
    @FormUrlEncoded
    @POST(Urls.MAKE_ORDER)
    Observable<MakeOrderBean> getMakeOrderBean(@FieldMap Map<String,String > map);
}
