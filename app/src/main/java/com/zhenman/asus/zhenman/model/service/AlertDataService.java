package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.AlartDataBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface AlertDataService {
//    修改个人资料
    @FormUrlEncoded
    @POST(Urls.ALART_MYDATA)
    Observable<AlartDataBean> getAlartData(@HeaderMap Map<String,String > headMap, @FieldMap Map<String,String> maps);
}
