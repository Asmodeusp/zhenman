package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.BuyEggplantContract;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.model.service.BuyEggplantService;
import com.zhenman.asus.zhenman.model.service.SerializationCatalogReadService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BuyEggplantPresenter implements BuyEggplantContract.BuyEggplantInPresenter {
    BuyEggplantContract.BuyEggplantInView buyEggplantInView;

    @Override
    public void sendProductListData(String type) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("type",type);
        RetrofitUtils.getInstance().getService(BuyEggplantService.class)
                .getProductList(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductListBean productListBean) {
                        if (productListBean.getState()==0){
                            buyEggplantInView.showProductListBean(productListBean);
                        }else {
                            buyEggplantInView.showError(productListBean.getMsg());
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
    public void setMakeOrderData(String productId, String type, String amount, String comment) {
        Map<String, String> maps = new HashMap<>();
        maps.put("productId", productId);
        maps.put("type", type);
        maps.put("amount", amount);
        maps.put("comment", "充值");
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getMakeOrderBean(maps)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MakeOrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MakeOrderBean makeOrderBean) {
                        if (makeOrderBean.getState() == 0) {
                            buyEggplantInView.getMakeOrderData(makeOrderBean);
                        } else {
                            buyEggplantInView.showError(makeOrderBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Sunny", e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void setWxMakeOrderData(String productId, String type, String amount, String comment) {
        Map<String, String> maps = new HashMap<>();
        maps.put("productId", productId);
        maps.put("type", type);
        maps.put("amount", amount);
        maps.put("comment", "充值");
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getWxMakeOrderBean(maps)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MakeOrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MakeOrderBean makeOrderBean) {
                        if (makeOrderBean.getState() == 0) {
                            buyEggplantInView.getWxMakeOrderData(makeOrderBean);
                        } else {
                            buyEggplantInView.showError(makeOrderBean.getMsg());
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
    public void sendGetPayData(String orderSn) {
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getPayData(orderSn)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetPayDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetPayDataBean getPayDataBean) {
                        if (getPayDataBean.getState() == 0) {

                            buyEggplantInView.showGetPayData(getPayDataBean);
                        } else {
                            buyEggplantInView.showError(getPayDataBean.getMsg());
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
    public void sendGetWxPayData(String orderSn) {
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getWXPayData(orderSn)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayWeChatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PayWeChatBean payWeChatBean) {
                        if (payWeChatBean .getState()==0) {
                            buyEggplantInView.showGetWxPayData(payWeChatBean);
                        }else {
                            buyEggplantInView.showError(payWeChatBean.getMsg());
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
    public void actualView(BuyEggplantContract.BuyEggplantInView buyEggplantInView) {
        this.buyEggplantInView = buyEggplantInView;
    }

    @Override
    public void unActualView() {
        this.buyEggplantInView = null;
    }
}
