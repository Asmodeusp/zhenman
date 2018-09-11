package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.AlartDataBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface AlertDataService {
//    修改个人资料
//    @FormUrlEncoded
//    @POST(Urls.ALART_MYDATA)
//    Observable<AlartDataBean> getAlartData(@HeaderMap Map<String,String > headMap, @FieldMap Map<String,String> maps);

    @Multipart
    @POST(Urls.ALART_MYDATA)
    Observable<AlartDataBean> upLoadPhoto(@HeaderMap Map<String,String> headMap,@PartMap Map<String, RequestBody> files);
}
