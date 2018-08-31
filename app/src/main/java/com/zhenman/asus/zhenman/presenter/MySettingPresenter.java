package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.MySettingContract;
import com.zhenman.asus.zhenman.model.bean.CancelLoginBean;
import com.zhenman.asus.zhenman.model.service.MySettingService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MySettingPresenter implements MySettingContract.MySettingInPresenter {
    MySettingContract.MySettingInView mySettingInView;
//    注销登陆
    @Override
    public void sendCancelLoginData(String mobile, String type, String otherUserId) {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("mobile",mobile);
        paramsMap.put("type",type);
        paramsMap.put("otherUserId",otherUserId);
        RetrofitUtils.getInstance().getService(MySettingService.class)
                .getCancleLoginData(paramsMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CancelLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CancelLoginBean cancelLoginBean) {
                        mySettingInView.showCancelLoginData(cancelLoginBean);
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
    public void actualView(MySettingContract.MySettingInView mySettingInView) {
        this.mySettingInView=mySettingInView;
    }

    @Override
    public void unActualView() {
        this.mySettingInView=null;
    }
}
