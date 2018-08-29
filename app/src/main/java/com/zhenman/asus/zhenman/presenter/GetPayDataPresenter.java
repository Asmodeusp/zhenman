package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.GetPayDataContract;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.service.GetPayDataService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GetPayDataPresenter implements GetPayDataContract.GetPayDataInpresenter {
    GetPayDataContract.GetPayDataInView getPayDataInView;

    @Override
    public void sendGetPayData(String orderSn) {
        RetrofitUtils.getInstance().getService(GetPayDataService.class)
                .getPayData(orderSn)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GetPayDataBean>() {
                    @Override
                    public void accept(GetPayDataBean getPayDataBean) throws Exception {
                        getPayDataInView.showGetPayData(getPayDataBean);
                    }
                });
    }

    @Override
    public void actualView(GetPayDataContract.GetPayDataInView getPayDataInView) {
        this.getPayDataInView = getPayDataInView;
    }

    @Override
    public void unActualView() {
        this.getPayDataInView = null;
    }
}
