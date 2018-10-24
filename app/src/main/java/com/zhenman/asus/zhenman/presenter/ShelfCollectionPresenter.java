package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.ShelfCollectionContract;
import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.model.service.ShelfCollectionService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShelfCollectionPresenter implements ShelfCollectionContract.ShelfCollectionInPresenter {
    ShelfCollectionContract.ShelfCollectionInView shelfCollectionInView;

    @Override
    public void sendShelfCollectionData(String pageNum, String pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);

        RetrofitUtils.getInstance().getService(ShelfCollectionService.class)
                .getShelfCollection(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShelfCollectionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShelfCollectionBean shelfCollectionBean) {
                        if (shelfCollectionBean.getState() == 0) {
                            shelfCollectionInView.showShelfCollection(shelfCollectionBean);
                        } else {
                            shelfCollectionInView.showError("获取数据失败");
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

    //    批量删除
    @Override
    public void sendDeleteCollection(ArrayList<String> lidList) {
        Map<String, String> paramMap = new IdentityHashMap<>();
        for (String s : lidList) {
            String Key = new String("lid");
            paramMap.put(Key, s);


        }
        RetrofitUtils.getInstance().getService(ShelfCollectionService.class)
                .deleteCollection(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationCodeBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            shelfCollectionInView.showDeleteCollection(verificationCodeBean);
                        } else {
                            shelfCollectionInView.showError(verificationCodeBean.getMsg());
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
    public void actualView(ShelfCollectionContract.ShelfCollectionInView shelfCollectionInView) {
        this.shelfCollectionInView = shelfCollectionInView;
    }

    @Override
    public void unActualView() {
        this.shelfCollectionInView = null;
    }
}
