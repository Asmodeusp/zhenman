package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.UMengLoginContract;
import com.zhenman.asus.zhenman.model.bean.ThirdPartyLoginBean;
import com.zhenman.asus.zhenman.model.bean.UMengLoginBean;
import com.zhenman.asus.zhenman.model.service.LoginService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UMengLoginPresenter implements UMengLoginContract.UMengLoginInPresenter {
    UMengLoginContract.UMengLoginInView uMengLoginInView;
    @Override
    public void sendUMengLoginData(String otherUserId, String name, String cityName, String headImg, String sex, String type, String openId) {
        Map<String,String> map=new HashMap<>();
        map.put("otherUserId",otherUserId);
        map.put("name",name);
        map.put("cityName",cityName);
        map.put("headImage",headImg);
        map.put("sex",sex);
        map.put("type",type);
        map.put("openId",openId);
        Map<String, String> headMap = new HashMap<>();
//        headMap.put("os","Android");
        RetrofitUtils.getInstance().getService(LoginService.class).GetThirdPartyLoginBean(headMap,map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ThirdPartyLoginBean>() {
                    @Override
                    public void accept(ThirdPartyLoginBean uMengLoginBean) throws Exception {
//                        uMengLoginInView.showUMengLoginData(uMengLoginBean);
                    }
                });
    }

    @Override
    public void actualView(UMengLoginContract.UMengLoginInView uMengLoginInView) {
        this.uMengLoginInView=uMengLoginInView;
    }

    @Override
    public void unActualView() {
        this.uMengLoginInView=null;
    }
}
