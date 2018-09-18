package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.TheamBeanContract;
import com.zhenman.asus.zhenman.model.bean.TheamBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.model.service.ThemeService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TheamBeanPresenter implements TheamBeanContract.TheamBeanInPresenter {
    TheamBeanContract.TheamBeanInView theamBeanInView;

    @Override
    public void sendTheamBean() {
        RetrofitUtils.getInstance().getService(ThemeService.class)
                .getTheamBeanData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TheamBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TheamBean theamBean) {
                        if (theamBean.getState() == 0) {
                            theamBeanInView.showTheamBean(theamBean);
                        } else {
                            theamBeanInView.showError(theamBean.getMsg());
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

    //关注主题
    @Override
    public void sendAttentionThemeData(String subjectId, String status) {
        HashMap<String, String> parmaMap = new HashMap<>();
        parmaMap.put("subjectId", subjectId);
        parmaMap.put("status", status);
        RetrofitUtils.getInstance().getService(ThemeService.class)
                .AttentionThemeData(parmaMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemeAttentionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ThemeAttentionBean themeAttentionBean) {

                        Log.e("9999999999",themeAttentionBean.getMsg());

                        if (themeAttentionBean.getData() == null) {
                            theamBeanInView.showError("取消关注成功");
                        } else {
                            theamBeanInView.showAttentionTheme(themeAttentionBean);
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
    public void actualView(TheamBeanContract.TheamBeanInView theamBeanInView) {
        this.theamBeanInView = theamBeanInView;
    }

    @Override
    public void unActualView() {
        this.theamBeanInView = null;
    }
}
