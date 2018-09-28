package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.MySelfContract;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.model.service.HomePageService;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MySelfPresenter implements MySelfContract.MySelfInPresenter {
    MySelfContract.MySelfInView mySelfInView;

    /*@Override
    public void sendGetMyData(String oauthId) {

        RetrofitUtils.getInstance().getService(MySelfService.class)
                .getMyDataBean(oauthId)
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
    }*/

    //个人首页头部信息
    @Override
    public void sendMyselfHeadData(String userId) {
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
                            mySelfInView.showMySelfHead(homePageHeadBean);
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
    public void actualView(MySelfContract.MySelfInView mySelfInView) {
        this.mySelfInView = mySelfInView;
    }

    @Override
    public void unActualView() {
        this.mySelfInView = null;
    }
}
