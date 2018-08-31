package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.contract.MySelfContract;
import com.zhenman.asus.zhenman.model.bean.GetMyDataBean;
import com.zhenman.asus.zhenman.model.service.MySelfService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MySelfPresenter implements MySelfContract.MySelfInPresenter {
    MySelfContract.MySelfInView mySelfInView;
    @Override
    public void sendGetMyData(String accessToken, String oauthId) {
        HashMap<String, String> headMap = new HashMap<>();
//        headMap.put("accessToken", (String) SPUtils.get(App.context, SPKey.USER_TOKEN,""));
        headMap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDY0MzMsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjY5MjM3ODlDRjhGQzJGOUE2OUQzQkFBMTU1QUMwQTRcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NzI0MjQzM30.MgRXQqZ-UXG6NyRU95PBpl2FQF84TjkU0bT-0bgXOMg");

        RetrofitUtils.getInstance().getService(MySelfService.class)
                .getMyDataBean(headMap,oauthId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetMyDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetMyDataBean getMyDataBean) {
                        mySelfInView.showGetMyData(getMyDataBean);
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
    public void actualView(MySelfContract.MySelfInView mySelfInView) {
        this.mySelfInView=mySelfInView;
    }

    @Override
    public void unActualView() {
        this.mySelfInView=null;
    }
}
