package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.SellEggplantContract;
import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;
import com.zhenman.asus.zhenman.model.bean.WeiXinTiXianBean;
import com.zhenman.asus.zhenman.model.service.SellEggplantService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SellEggplantPresenter implements SellEggplantContract.SellEggplantInPresenter {
    SellEggplantContract.SellEggplantInView sellEggplantInView;

    //    茄子明细
    @Override
    public void sendSellEggplant() {

        RetrofitUtils.getInstance().getService(SellEggplantService.class)
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
    public void sendWeixinTixian(String eggplantAmount, String biteEggplantAmount, String unripeEggplantAmount, String amount) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("eggplantAmount", eggplantAmount);
        paramMap.put("biteEggplantAmount", biteEggplantAmount);
        paramMap.put("unripeEggplantAmount", unripeEggplantAmount);
        paramMap.put("amount", amount);
        RetrofitUtils.getInstance().getService(SellEggplantService.class)
                .getWeiXinTixian(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeiXinTiXianBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeiXinTiXianBean weiXinTiXianBean) {
                        if (weiXinTiXianBean.getState() == 0) {
                            sellEggplantInView.showWeiXinTixian(weiXinTiXianBean);
                        } else {
                            sellEggplantInView.showError(weiXinTiXianBean.getMsg());
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
