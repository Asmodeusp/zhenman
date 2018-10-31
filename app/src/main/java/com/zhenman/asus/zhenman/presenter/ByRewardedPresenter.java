package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.ByRewardedContract;
import com.zhenman.asus.zhenman.model.bean.ByRewardedBean;
import com.zhenman.asus.zhenman.model.service.ByRewardedService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ByRewardedPresenter implements ByRewardedContract.ByRewardedInPresenter {
    ByRewardedContract.ByRewardedInView byRewardedInView;

    @Override
    public void sendByRewardedData(String accessToken,String pageNum, String pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);
        Map<String, String> headMap = new HashMap<>();
        headMap.put("accessToken", accessToken);

        RetrofitUtils.getInstance().getService(ByRewardedService.class)
                .getByRewarded(headMap,paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ByRewardedBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ByRewardedBean byRewardedBean) {
                        if (byRewardedBean.getState() == 0) {
                            byRewardedInView.showByRewardedData(byRewardedBean);
                        } else {
                            byRewardedInView.showError(byRewardedBean.getMsg());
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
    public void actualView(ByRewardedContract.ByRewardedInView byRewardedInView) {
        this.byRewardedInView = byRewardedInView;
    }

    @Override
    public void unActualView() {
        this.byRewardedInView = null;
    }
}
