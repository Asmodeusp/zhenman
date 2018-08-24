package com.zhenman.asus.zhenman.model.service;


import com.zhenman.asus.zhenman.model.bean.UMengLoginBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;


import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;


public interface UMengLoginService {
    @FormUrlEncoded
    @POST(Urls.UMENG_LOGIN)
    Observable<UMengLoginBean> getUMengLoginData(@FieldMap Map<String, String> map);
}
