package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.MakeOrderContract;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.service.MakeOrderService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

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
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("accessToken","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");

        Map<String,String > maps=new HashMap<>();
        maps.put("productId",productId);
        maps.put("type",type);
        maps.put("catalogId",catalogId);
        maps.put("toUserId",toUserId);
        maps.put("amount",amount);
        RetrofitUtils.getInstance().getService(MakeOrderService.class)
                .getMakeOrderBean(maps,headerMap)
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
