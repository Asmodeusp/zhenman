package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.WorkCatalogContract;
import com.zhenman.asus.zhenman.model.bean.RenewBean;
import com.zhenman.asus.zhenman.model.service.WorkCatalogService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class WorkCatalogPresenterImp implements WorkCatalogContract.WorkCatalogPresenter {
    WorkCatalogContract.WorkCatalogView workCatalogView;
    @Override
    public void getRenewBean(String status, String pgcId) {
        Map<String, String> map = new HashMap<>();
        map.put("status", status);
        map.put("pgcId", pgcId);

        RetrofitUtils.getInstance().getService(WorkCatalogService.class).GetRenewBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RenewBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RenewBean renewBean) {
                        if (renewBean.getState() == 0) {
                            workCatalogView.showError(renewBean.getMsg());

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
    public void actualView(WorkCatalogContract.WorkCatalogView workCatalogView) {
            this.workCatalogView = workCatalogView;
    }

    @Override
    public void unActualView() {
        this.workCatalogView =null;
    }
}
