package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface PgcCollectionService {
    //PGC收藏
    @FormUrlEncoded
    @POST(Urls.PGC_COLLECTION)
    Observable<PgcCollectionBean> GetPgcCollectionBean(@HeaderMap Map<String,String > Heards, @FieldMap Map<String, String> params);
}
