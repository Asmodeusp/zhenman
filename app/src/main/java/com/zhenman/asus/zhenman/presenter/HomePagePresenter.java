package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.HomePageContract;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.model.service.HomePageService;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePagePresenter implements HomePageContract.HomePageInPresenter {
    HomePageContract.HomePageInView homePageInView;

    @Override
    public void sendHomePageHeadData(String accessToken, String userId) {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        RetrofitUtils.getInstance().getService(HomePageService.class)
                .getHomePageHeadData( paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomePageHeadBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomePageHeadBean homePageHeadBean) {
                        if (homePageHeadBean.getMsg().equals(GetData.MSG_SUCCESS)) {
                            homePageInView.showHomePageHead(homePageHeadBean);
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

    @Override
    public void actualView(HomePageContract.HomePageInView homePageInView) {
        this.homePageInView = homePageInView;
    }

    @Override
    public void unActualView() {
        this.homePageInView = null;
    }
}
