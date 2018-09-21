package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AccountManagementService {
//    虽然是三方账号登陆但是已经绑定过手机号的话，再绑定三方账号就是手机号绑定三方账号了
    @FormUrlEncoded
    @POST(Urls.MOBILE_BIND_THIRD)
    Observable<VerificationCodeBean> getPhoneBindThird(@FieldMap Map<String, String> paramMap);
    //    三方账号登陆还没有绑定过手机号的话就是三方账号绑定三方账号
    @FormUrlEncoded
    @POST(Urls.THIRD_BIND_THIRD)
    Observable<VerificationCodeBean> getThirdBindThird(@FieldMap Map<String, String> paramMap);
}
