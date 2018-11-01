package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.ByFansContract;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.ByFansBean;
import com.zhenman.asus.zhenman.model.service.ByFansService;
import com.zhenman.asus.zhenman.model.service.MyFansService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ByfansPresenter implements ByFansContract.ByFansInPresenter {
    ByFansContract.ByFansInView byFansInView;

    @Override
    public void sendByFansData(String pageNum, String pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNum",pageNum);
        paramMap.put("pageSize",pageSize);
        RetrofitUtils.getInstance().getService(ByFansService.class)
                .getByFansData(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ByFansBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ByFansBean byFansBean) {
                        if (byFansBean.getState()==0){
                            byFansInView.showByFansData(byFansBean);
                        }else {
                            byFansInView.showError(byFansBean.getMsg());
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
                            byFansInView.showAttentionUser(verificationCodeBean);
                        }else {
                            byFansInView.showError(verificationCodeBean.getMsg());
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
    public void actualView(ByFansContract.ByFansInView byFansInView) {
        this.byFansInView = byFansInView;
    }

    @Override
    public void unActualView() {
        this.byFansInView = null;
    }
}
