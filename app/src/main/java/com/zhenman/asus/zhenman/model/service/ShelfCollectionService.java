package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ShelfCollectionService {
//    书架收藏
    @GET(Urls.SHELF_COLLECTION)
    Observable<ShelfCollectionBean> getShelfCollection(@QueryMap Map<String,String> paramMap);
//    取消收藏
    @FormUrlEncoded
    @POST(Urls.DELETE_COLLECTION)
    Observable<VerificationCodeBean> deleteCollection(@FieldMap Map<String,String> paramMap);

}
