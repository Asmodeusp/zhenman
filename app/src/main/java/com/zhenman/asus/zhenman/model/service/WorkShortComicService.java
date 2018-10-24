package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.WorkShortComicBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WorkShortComicService {
    @GET(Urls.UGS_SHORT_COMIC)//UGC段漫画
    Observable <WorkShortComicBean> getWorkShortComicBean(@QueryMap Map<String,String> paramMap);
}
