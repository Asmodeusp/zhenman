package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.ShelfHistoryListBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ShelfHistoryListService {
    @GET(Urls.SHELF_HISTORY)//书架历史列表
    Observable<ShelfHistoryListBean> getShelfHistory(@QueryMap Map<String,String> paramMap);
}
