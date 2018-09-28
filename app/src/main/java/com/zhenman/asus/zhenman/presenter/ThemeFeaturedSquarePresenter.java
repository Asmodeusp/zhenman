package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.ThemeFeaturedSquareContract;
import com.zhenman.asus.zhenman.model.bean.ThemeFeaturedBean;
import com.zhenman.asus.zhenman.model.service.ThemeFeaturedSquareService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ThemeFeaturedSquarePresenter implements ThemeFeaturedSquareContract.ThemeFeaturedSquareInPresenter {
    ThemeFeaturedSquareContract.ThemeFeaturedSquareInView themeFeaturedSquareInView;

    @Override
    public void sendThemeFeaturedSquareData(String subjectId, String pageNum, String pageSize, String type) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("subjectId", subjectId);
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);
        paramMap.put("type", type);
        RetrofitUtils.getInstance().getService(ThemeFeaturedSquareService.class)
                .getThemeFeaturedSquareData(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemeFeaturedBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ThemeFeaturedBean themeFeaturedBean) {
                        if (themeFeaturedBean.getState() == 0) {
                            themeFeaturedSquareInView.showThemeFeaturedSquareData(themeFeaturedBean);
                        } else {
                            themeFeaturedSquareInView.showError(themeFeaturedBean.getMsg());
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
    public void actualView(ThemeFeaturedSquareContract.ThemeFeaturedSquareInView themeFeaturedSquareInView) {
        this.themeFeaturedSquareInView = themeFeaturedSquareInView;
    }

    @Override
    public void unActualView() {
        this.themeFeaturedSquareInView = null;
    }
}
