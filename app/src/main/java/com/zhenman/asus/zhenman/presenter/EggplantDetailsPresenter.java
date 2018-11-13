package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.EggplantDetailsContract;
import com.zhenman.asus.zhenman.model.bean.EggplantDetailsBean;
import com.zhenman.asus.zhenman.model.service.EggplantDetailsService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EggplantDetailsPresenter implements EggplantDetailsContract.EggplantDetailsInPresenter {
    EggplantDetailsContract.EggplantDetailsInView eggplantDetailsInView;

    //    茄子明细
    @Override
    public void sendEggplantDetailsData(String pageNum, String pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);
        RetrofitUtils.getInstance().getService(EggplantDetailsService.class)
                .getEggplantDetails(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EggplantDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EggplantDetailsBean eggplantDetailsBean) {
                        if (eggplantDetailsBean.getState() == 0) {
                            eggplantDetailsInView.showEggplantDetailsData(eggplantDetailsBean);
                        } else {
                            eggplantDetailsInView.showError(eggplantDetailsBean.getMsg());
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
    public void actualView(EggplantDetailsContract.EggplantDetailsInView eggplantDetailsInView) {
        this.eggplantDetailsInView = eggplantDetailsInView;
    }

    @Override
    public void unActualView() {
        this.eggplantDetailsInView = null;
    }
}
