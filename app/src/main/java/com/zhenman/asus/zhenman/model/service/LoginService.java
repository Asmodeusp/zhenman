package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ThirdPartyLoginBean;
import com.zhenman.asus.zhenman.model.bean.UserBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    //登录
    @FormUrlEncoded
    @POST(Urls.LOGING)
    Observable<UserBean> GetUserBean(@FieldMap Map<String, String> params);
    //第三方登陆
    @FormUrlEncoded
    @POST(Urls.THIRD_PARTY_LOGING)
    Observable<ThirdPartyLoginBean> GetThirdPartyLoginBean(@FieldMap Map<String, String> params);
}
