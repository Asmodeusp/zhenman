package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.AlartDataContract;
import com.zhenman.asus.zhenman.model.bean.AlartDataBean;
import com.zhenman.asus.zhenman.model.service.AlertDataService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class AlartDataPresenter implements AlartDataContract.AlartDataInPresenter {
    AlartDataContract.AlartDataInView alartDataInView;
    @Override
    public void sendAlartData(String accessToken, String oauthId, String sex, String name, String introduction, String headImg, String birthdate) {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("accessToken",accessToken);
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("oauthId",oauthId);
        paramsMap.put("sex",sex);
        paramsMap.put("name",name);
        paramsMap.put("introduction",introduction);
        paramsMap.put("headImg",headImg);
        paramsMap.put("birthdate",birthdate);
        RetrofitUtils.getInstance().getService(AlertDataService.class)
                .getAlartData(headMap,paramsMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AlartDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AlartDataBean alartDataBean) {
                        alartDataInView.showAlartData(alartDataBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void actualView(AlartDataContract.AlartDataInView alartDataInView) {
        this.alartDataInView=alartDataInView;
    }

    @Override
    public void unActualView() {
this.alartDataInView=null;
    }
}
