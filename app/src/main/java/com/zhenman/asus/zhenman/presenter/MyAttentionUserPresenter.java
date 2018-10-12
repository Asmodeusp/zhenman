package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.MyAttentionUserContract;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.model.service.MyAttentionUserService;
import com.zhenman.asus.zhenman.model.service.MyFansService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyAttentionUserPresenter implements MyAttentionUserContract.MyAttentionUserInPresenter {
    MyAttentionUserContract.MyAttentionUserInView myAttentionUserInView;

    @Override
    public void sendMyAttentionUserData(String pageNum, String pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);

        RetrofitUtils.getInstance().getService(MyAttentionUserService.class)
                .getMyAttentionUser(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyAttentionUserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyAttentionUserBean attentionUserBean) {
                        if (attentionUserBean.getState() == 0) {
                            myAttentionUserInView.showMyAttentionUserData(attentionUserBean);
                        } else {
                            myAttentionUserInView.showError(attentionUserBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Sunny", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
//关注用户
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
                            myAttentionUserInView.showAttentionUser(verificationCodeBean);
                        }else {
                            myAttentionUserInView.showError(verificationCodeBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Sunny",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void actualView(MyAttentionUserContract.MyAttentionUserInView myAttentionUserInView) {
        this.myAttentionUserInView = myAttentionUserInView;
    }

    @Override
    public void unActualView() {
        this.myAttentionUserInView = null;
    }
}
