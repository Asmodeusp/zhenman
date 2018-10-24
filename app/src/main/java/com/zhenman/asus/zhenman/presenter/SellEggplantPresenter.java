package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.SellEggplantContract;
import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;
import com.zhenman.asus.zhenman.model.service.EggplantDetailsService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SellEggplantPresenter implements SellEggplantContract.SellEggplantInPresenter {
    SellEggplantContract.SellEggplantInView sellEggplantInView;

    //    茄子明细
    @Override
    public void sendSellEggplant() {

        RetrofitUtils.getInstance().getService(EggplantDetailsService.class)
                .getSellEggplant()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SellEggplantBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SellEggplantBean eggplantDetailsBean) {
                        if (eggplantDetailsBean.getState() == 0) {
                            sellEggplantInView.showSellEggplant(eggplantDetailsBean);
                        } else {
                            sellEggplantInView.showError(eggplantDetailsBean.getMsg());
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
    public void actualView(SellEggplantContract.SellEggplantInView eggplantDetailsInView) {
        this.sellEggplantInView = eggplantDetailsInView;
    }

    @Override
    public void unActualView() {
        this.sellEggplantInView = null;
    }
}
