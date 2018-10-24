package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.MyFansContract;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.MyFansBean;
import com.zhenman.asus.zhenman.model.service.MyFansService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyFansPresenter implements MyFansContract.MyFansInPresenter {
    MyFansContract.MyFansInView myFansInView;

    @Override
    public void sendMyFansData(String pageNum, String pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);
        RetrofitUtils.getInstance().getService(MyFansService.class)
                .getMyFansData(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyFansBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyFansBean myFansBean) {
                        if (myFansBean.getState() == 0) {
                            myFansInView.showMyFansData(myFansBean);
                        } else {
                            myFansInView.showError(myFansBean.getMsg());
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

    //    关注用户
    @Override
    public void sendAttentionUserData(String followedUserId, String status) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("followedUserId", followedUserId);
        paramMap.put("status", status);
        RetrofitUtils.getInstance().getService(MyFansService.class)
                .getAttentionUser(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AttentionMyFansBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttentionMyFansBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            myFansInView.showAttentionUser(verificationCodeBean);
                        }else {
                            myFansInView.showError(verificationCodeBean.getMsg());
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
    public void actualView(MyFansContract.MyFansInView myFansInView) {
        this.myFansInView = myFansInView;
    }

    @Override
    public void unActualView() {
        this.myFansInView = null;
    }
}

