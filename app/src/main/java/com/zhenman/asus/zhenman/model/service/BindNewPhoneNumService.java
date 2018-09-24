package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BindNewPhoneNumService {
    //三方账号登陆绑定手机号
    @FormUrlEncoded
    @POST(Urls.CHANGE_MOBILE)
    Observable<VerificationCodeBean> changeMobileNum(@FieldMap Map<String, String> params);
    //发送图片验证码到服务器得到短信验证码
    @FormUrlEncoded
    @POST(Urls.REQUEST_CELL_PHONE_VERIFICATION_CODE)
    Observable<VerificationCodeBean> getSMSCodeBean(@FieldMap Map<String, String> params);

}
