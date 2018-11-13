package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.EggplantDetailsBean;
import com.zhenman.asus.zhenman.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface EggplantDetailsService {
    @GET(Urls.EGGPLANT_DETAILS)//茄子明细
    Observable<EggplantDetailsBean> getEggplantDetails(@QueryMap Map<String,String> paramMap);
}
