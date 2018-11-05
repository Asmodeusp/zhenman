package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.ByLikeContract;
import com.zhenman.asus.zhenman.model.bean.ByLikeBean;
import com.zhenman.asus.zhenman.model.service.ByLikeService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ByLikePresenter implements ByLikeContract.ByLikeInPresenter {
    ByLikeContract.ByLikeInView byLikeInView;

    @Override
    public void sendByLikeData(String pageNum, String pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);
        RetrofitUtils.getInstance().getService(ByLikeService.class)
                .getByLikeBean(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ByLikeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ByLikeBean byLikeBean) {
                        if (byLikeBean.getState() == 0) {
                            byLikeInView.showByLikeData(byLikeBean);
                        } else {
                            byLikeInView.showError(byLikeBean.getMsg());
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
    public void actualView(ByLikeContract.ByLikeInView byLikeInView) {
        this.byLikeInView = byLikeInView;
    }

    @Override
    public void unActualView() {
        this.byLikeInView = null;
    }
}
