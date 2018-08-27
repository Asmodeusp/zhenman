package com.zhenman.asus.zhenman.model.service;


import com.zhenman.asus.zhenman.model.bean.ClassifyTagBean;
import com.zhenman.asus.zhenman.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SerializationClassifyService {
    //连载分类标签
    @GET(Urls.SERIALIZATION_CLASSIFY_TAG)
    Observable<ClassifyTagBean> GetClassifyTagBean();
}
