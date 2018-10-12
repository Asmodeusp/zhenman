package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.ThemeDetailHeadContract;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.ThemeDetailHeadBean;
import com.zhenman.asus.zhenman.model.service.ThemeDetailsHeadService;
import com.zhenman.asus.zhenman.model.service.ThemeService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ThemeDetailsPresenter implements ThemeDetailHeadContract.ThemeDetailHeadInPresenter {
    ThemeDetailHeadContract.ThemeDetailHeadInView themeDetailHeadInView;

    @Override
    public void sendThemeDetailHeadData(String subjectId) {
        RetrofitUtils.getInstance().getService(ThemeDetailsHeadService.class)
                .getThemeDetailHead(subjectId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemeDetailHeadBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ThemeDetailHeadBean themeDetailHeadBean) {
                        if (themeDetailHeadBean.getState() == 0) {
                            themeDetailHeadInView.showThemeDetailHeadData(themeDetailHeadBean);
                        } else {
                            themeDetailHeadInView.showError(themeDetailHeadBean.getMsg());
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
                        if (themeAttentionBean.getData() == null) {
                            themeDetailHeadInView.showError("取消关注成功");
                        } else {
                            themeDetailHeadInView.showAttentionTheme(themeAttentionBean);
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
    public void actualView(ThemeDetailHeadContract.ThemeDetailHeadInView themeDetailHeadInView) {
        this.themeDetailHeadInView = themeDetailHeadInView;
    }

    @Override
    public void unActualView() {
        this.themeDetailHeadInView = null;
    }
}
