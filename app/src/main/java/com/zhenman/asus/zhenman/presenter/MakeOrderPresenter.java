package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.contract.MakeOrderContract;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.service.MakeOrderService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MakeOrderPresenter implements MakeOrderContract.MakeOrderInPresenter {
    MakeOrderContract.MakeOrderInView productListInView;

    @Override
    public void actualView(MakeOrderContract.MakeOrderInView productListInView) {
        this.productListInView = productListInView;
    }

    @Override
    public void unActualView() {
        this.productListInView = null;
    }

    @Override
    public void setProductListData(String productId, String type, String catalogId, String toUserId, String amount) {
        Map<String,String > maps=new HashMap<>();
        maps.put("productId",productId);
        maps.put("type",type);
        maps.put("catalogId",catalogId);
        maps.put("toUserId",toUserId);
        maps.put("amount",amount);
        RetrofitUtils.getInstance().getService(MakeOrderService.class)
                .getMakeOrderBean(maps)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MakeOrderBean>() {
                    @Override
                    public void accept(MakeOrderBean productListBean) throws Exception {
                        productListInView.getProductListData(productListBean);
                    }
                });
    }
}
