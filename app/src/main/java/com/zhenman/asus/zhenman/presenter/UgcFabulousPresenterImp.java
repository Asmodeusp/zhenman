package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.contract.UgcFabulousContract;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

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
//        Headermap.put("accessToken",  (String) SPUtils.get(App.context, SPKey.USER_TOKEN,""));
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDY0MzMsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjY5MjM3ODlDRjhGQzJGOUE2OUQzQkFBMTU1QUMwQTRcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NzI0MjQzM30.MgRXQqZ-UXG6NyRU95PBpl2FQF84TjkU0bT-0bgXOMg");

        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("status", status);
        RetrofitUtils.getInstance().getUgcFabulousService().GetUgcFabulousBean(Headermap,map)
                .subscribeOn(Schedulers.newThread())
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
