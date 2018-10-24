package com.zhenman.asus.zhenman.model.service;

import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;
import com.zhenman.asus.zhenman.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface EggplantDetailsService {
//    茄子数量
    @GET(Urls.SELL_EGGPLANT)
    Observable<SellEggplantBean> getSellEggplant();
}
