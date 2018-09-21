package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AlartPhoneNumService {

    //发送图片验证码到服务器得到短信验证码
    @FormUrlEncoded
    @POST(Urls.REQUEST_CELL_PHONE_VERIFICATION_CODE)
    Observable<VerificationCodeBean> GetSMSCodeBean(@FieldMap Map<String, String> params);

    //    账号绑定更换前的密码校验
    @FormUrlEncoded
    @POST(Urls.CHECK_CODE)
    Observable<VerificationCodeBean> checkCodeBean(@FieldMap Map<String, String> params);

    //三方账号登陆绑定手机号
    @FormUrlEncoded
    @POST(Urls.THIRD_BIND_PHONE)
    Observable<VerificationCodeBean> replacePhoneNum(@FieldMap Map<String, String> params);

}
