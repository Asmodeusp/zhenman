package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.GetMyDataBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface MySelfService {
//    个人资料头部信息

//    得到个人资料
    @GET(Urls.GET_MYDATA)
    Observable<GetMyDataBean> getMyDataBean(@HeaderMap Map<String,String >headMap,@Query("oauthId") String oauthId);
}
