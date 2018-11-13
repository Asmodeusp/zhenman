package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.WorkShortPgcComicBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WorkShortPgcComicService {
    @GET(Urls.PGC_SHORT_COMIC)//pgc漫画
    Observable<WorkShortPgcComicBean> getWorkShortPgcComicBean(@QueryMap Map<String,String> paramMap);
}
