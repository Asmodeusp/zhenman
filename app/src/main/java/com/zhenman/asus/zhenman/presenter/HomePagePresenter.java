package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.HomePageContract;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.model.service.HomePageService;
import com.zhenman.asus.zhenman.model.service.SerializationCatalogReadService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePagePresenter implements HomePageContract.HomePageInPresenter {
    HomePageContract.HomePageInView homePageInView;

    @Override
    public void sendHomePageHeadData(String userId) {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        RetrofitUtils.getInstance().getService(HomePageService.class)
                .getHomePageHeadData(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomePageHeadBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomePageHeadBean homePageHeadBean) {
                        if (homePageHeadBean.getState()==0) {
                            homePageInView.showHomePageHead(homePageHeadBean);
                        }else {
                            homePageInView.showError(homePageHeadBean.getMsg());
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

    //关注用户
    @Override
    public void sendAttentionUserData(String followedUserId, String status) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("followedUserId", followedUserId);
        paramMap.put("status", status);
        RetrofitUtils.getInstance().getService(HomePageService.class)
                .getAttentionUser(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AttentionMyFansBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttentionMyFansBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            homePageInView.showAttentionUser(verificationCodeBean);
                        } else {
                            homePageInView.showError(verificationCodeBean.getMsg());
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

    //    创建支付宝订单
    @Override
    public void setMakeOrderData(String productId, String type, String toUserId, String amount, String comment) {
        Map<String, String> maps = new HashMap<>();
        maps.put("productId", productId);
        maps.put("type", type);
        maps.put("toUserId", toUserId);
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
                            homePageInView.getMakeOrderData(makeOrderBean);
                        } else {
                            homePageInView.showError(makeOrderBean.getMsg());
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

    //创建微信订单
    @Override
    public void setWxMakeOrderData(String productId, String type, String toUserId, String amount, String comment) {
        Map<String, String> maps = new HashMap<>();
        maps.put("productId", productId);
        maps.put("type", type);
        maps.put("toUserId", toUserId);
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
                            homePageInView.getWxMakeOrderData(makeOrderBean);
                        } else {
                            homePageInView.showError(makeOrderBean.getMsg());
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

    //得到支付宝支付数据
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

                            homePageInView.showGetPayData(getPayDataBean);
                        } else {
                            homePageInView.showError(getPayDataBean.getMsg());
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

    //得到微信支付数据
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
                            homePageInView.showGetWxPayData(payWeChatBean);
                        }else {
                            homePageInView.showError(payWeChatBean.getMsg());
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

    //得到产品列表
    @Override
    public void sendProductListData(String type) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("type", type);//项目购买的有两种，茄子和茄子籽，两个产品列表都是这一个接口，区别就是type=1是请求茄子，type=2是请求茄子籽
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getProductList(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductListBean productListBean) {
                        if (productListBean.getState()==0) {
                            homePageInView.showProductListBean(productListBean);
                        }else {
                            homePageInView.showError(productListBean.getMsg());
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
    public void actualView(HomePageContract.HomePageInView homePageInView) {
        this.homePageInView = homePageInView;
    }

    @Override
    public void unActualView() {
        this.homePageInView = null;
    }
}
