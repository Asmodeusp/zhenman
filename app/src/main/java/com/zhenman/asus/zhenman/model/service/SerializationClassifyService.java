package com.zhenman.asus.zhenman.model.service;


import com.zhenman.asus.zhenman.model.bean.ClassifyBean;
import com.zhenman.asus.zhenman.model.bean.ClassifyTagBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface SerializationClassifyService {
    //连载分类标签
    @GET(Urls.SERIALIZATION_CLASSIFY_TAG)
    Observable<ClassifyTagBean> GetClassifyTagBean();
    //连载分类列表
    @GET(Urls.SERIALIZATION_CLASSIFY)
    Observable<ClassifyBean> GetClassifyBean( @QueryMap Map<String,String> params);

}
