package com.zhenman.asus.zhenman.model.service;


import com.zhenman.asus.zhenman.model.bean.RegisterLoginCodeBean;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterVerificationCodeService {
    //注册
    @FormUrlEncoded
    @POST(Urls.REQUEST_CELL_PHONE_VERIFICATION_CODE)
    Observable<VerificationCodeBean> GetVerificationCodeBean(@FieldMap Map<String, String> params);
    //注册手机号和验证码
    @FormUrlEncoded
    @POST(Urls.REGISTER_PHONE_CODE)
    Observable<RegisterLoginCodeBean> GetRegisterLoginCodeBean(@FieldMap Map<String, String> params);
}
