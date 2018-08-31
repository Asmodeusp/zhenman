package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.CancelLoginBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MySettingService {
    @FormUrlEncoded
    @POST(Urls.CANCLE_LOGIN)
    Observable<CancelLoginBean> getCancleLoginData(@FieldMap Map<String, String> paramsMap);
}
