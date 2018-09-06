package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.PurchaseHistoryContract;
import com.zhenman.asus.zhenman.model.bean.PurchaseHistoryBean;
import com.zhenman.asus.zhenman.model.service.PurchaseHistoryService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PurchaseHistoryPresenter implements PurchaseHistoryContract.PurchaseHistoryInPresenter {
    PurchaseHistoryContract.PurchaseHistoryInView purchaseHistoryInView;

    @Override
    public void sendPurchaseHistory(String accessToken,String pageNum, String pageSize) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("pageNum", pageNum);
        stringMap.put("pageSize", pageSize);
        Map<String, String> headMap = new HashMap<>();
        headMap.put("accessToken",accessToken);

        RetrofitUtils.getInstance().getService(PurchaseHistoryService.class)
                .getPurchaseHistoryBean(headMap,stringMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PurchaseHistoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PurchaseHistoryBean purchaseHistoryBean) {
                        if (purchaseHistoryBean != null) {
                            purchaseHistoryInView.showPurchaseHistory(purchaseHistoryBean);
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
    public void actualView(PurchaseHistoryContract.PurchaseHistoryInView purchaseHistoryInView) {
        this.purchaseHistoryInView = purchaseHistoryInView;
    }

    @Override
    public void unActualView() {
        this.purchaseHistoryInView = null;
    }
}
