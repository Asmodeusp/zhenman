package com.zhenman.asus.zhenman.model.service;


import com.zhenman.asus.zhenman.model.bean.RenewBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface WorkCatalogService {
    //续购开关
    @FormUrlEncoded
    @POST(Urls.RENEW)
    Observable<RenewBean> GetRenewBean(@FieldMap Map<String, String> params);
}
