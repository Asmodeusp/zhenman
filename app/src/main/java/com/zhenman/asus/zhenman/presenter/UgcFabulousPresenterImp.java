package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.UgcFabulousContract;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UgcFabulousPresenterImp implements UgcFabulousContract.UgcFabulousPresenter {
    UgcFabulousContract.UgcFabulousView ugcFabulousView;


    @Override
    public void actualView(UgcFabulousContract.UgcFabulousView ugcFabulousView) {
        this.ugcFabulousView = ugcFabulousView;
    }

    @Override
    public void unActualView() {
        this.ugcFabulousView = null;
    }

    @Override
    public void UgcFabulous(String productId, String status) {
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("status", status);
        RetrofitUtils.getInstance().getUgcFabulousService().GetUgcFabulousBean(Headermap,map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UgcFabulousBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UgcFabulousBean ugcFabulousBean) {
                        if (ugcFabulousBean.getState() == 0) {
                            ugcFabulousView.showError(ugcFabulousBean.getMsg());
                            ugcFabulousView.showUgcFabulousBean(ugcFabulousBean);
                        } else {
                            ugcFabulousView.showError(ugcFabulousBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
