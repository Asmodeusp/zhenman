package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ShelfCollectionService {
    @GET(Urls.SHELF_COLLECTION)
    Observable<ShelfCollectionBean> getShelfCollection(@QueryMap Map<String,String> paramMap);
}
