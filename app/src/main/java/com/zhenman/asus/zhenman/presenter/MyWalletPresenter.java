package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.MyWalletContract;
import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;
import com.zhenman.asus.zhenman.model.service.EggplantDetailsService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MyWalletPresenter implements MyWalletContract.SellEggplantInPresenter {
    MyWalletContract.SellEggplantInView sellEggplantInView;


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
    public void actualView(MyWalletContract.SellEggplantInView sellEggplantInView) {
this.sellEggplantInView=sellEggplantInView;
    }

    @Override
    public void unActualView() {
this.sellEggplantInView=null;
    }
}
