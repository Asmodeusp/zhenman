package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.MyAttenThemeContract;
import com.zhenman.asus.zhenman.model.bean.MyAttenThemeBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.model.service.MyAttenThemeService;
import com.zhenman.asus.zhenman.model.service.ThemeService;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyAttenThemePresenter implements MyAttenThemeContract.MyAttenThemeInPresenter {
    MyAttenThemeContract.MyAttenThemeInView myAttenThemeInView;

    @Override
    public void sendMyAttenThemeData(String otherUserId, String pageNum, String pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("otherUserId", otherUserId);
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);

        RetrofitUtils.getInstance().getService(MyAttenThemeService.class)
                .getMyAttenThemeBean(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyAttenThemeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyAttenThemeBean myAttenThemeBean) {
                        if (myAttenThemeBean.getMsg().equals(GetData.MSG_SUCCESS)) {
                            myAttenThemeInView.showMyAttenTheme(myAttenThemeBean);
                        } else {
                            myAttenThemeInView.showError(myAttenThemeBean.getMsg());
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


                        if (themeAttentionBean.getData() == null) {
                            myAttenThemeInView.showError("取消关注成功");
                        } else {
                            myAttenThemeInView.showAttentionTheme(themeAttentionBean);
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
    public void actualView(MyAttenThemeContract.MyAttenThemeInView myAttenThemeInView) {
        this.myAttenThemeInView = myAttenThemeInView;
    }

    @Override
    public void unActualView() {
        this.myAttenThemeInView = null;
    }
}
