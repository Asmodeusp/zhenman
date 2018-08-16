package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.SetPasswordBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SetPasswordService {
    //设置密码
    @FormUrlEncoded
    @POST(Urls.SET_PASSWORD)
    Observable<SetPasswordBean> GetSetPassWordBean(@FieldMap Map<String, String> params);
}
