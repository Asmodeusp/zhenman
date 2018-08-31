package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.contract.SerializationCatalogReadContract;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.model.service.SerializationCatalogReadService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SerializationCatalogReadPresenterImp implements SerializationCatalogReadContract.serializationCatalogReadPresenter {
    SerializationCatalogReadContract.serializationCatalogReadView serializationCatalogReadView;

    @Override
    public void getSerializationCatalogReadBean(String catalogId) {
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken", (String) SPUtils.get(App.context, SPKey.USER_TOKEN,""));
        Map<String, String> map = new HashMap<>();
        map.put("catalogId", catalogId);
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getSerializationCatalogReadBean(Headermap,map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerializationCatalogReadBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(SerializationCatalogReadBean serializationCatalogReadBean) {
                        if (serializationCatalogReadBean.getState() == 0) {
                            serializationCatalogReadView.showError(serializationCatalogReadBean.getMsg());
                            serializationCatalogReadView.showserializationCatalogReadBean(serializationCatalogReadBean);
                        } else {
                            serializationCatalogReadView.showError(serializationCatalogReadBean.getMsg());
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
    public void getSerializationCatalogBean(String PgcId) {
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> map = new HashMap<>();
        map.put("pgcId", PgcId);
        RetrofitUtils.getInstance()
                .getService(SerializationCatalogReadService.class)
                .getSerializationCatalogBean(Headermap,map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerializationCatalogBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(SerializationCatalogBean userBean) {
                        if (userBean.getState() == 0) {
                            serializationCatalogReadView.showError(userBean.getMsg());
                            serializationCatalogReadView.showSerializationCatalogBean(userBean);
                        } else {
                            serializationCatalogReadView.showError(userBean.getMsg());
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
    public void getSerializationDetailsBean(String PgcId) {
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> map = new HashMap<>();
        map.put("pgcId", PgcId);
        RetrofitUtils.getInstance().getSerializationDetailsService().GetSerializationDetailsBean(Headermap,map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerializationDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(SerializationDetailsBean userBean) {
                        if (userBean.getState() == 0) {
                            serializationCatalogReadView.showError(userBean.getMsg());
                            serializationCatalogReadView.showSerializationDetailsBean(userBean);
                        } else {
                            serializationCatalogReadView.showError(userBean.getMsg());
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
//    创建订单
    @Override
    public void setMakeOrderData(String productId, String type, String catalogId, String toUserId, String amount,String comment) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("accessToken","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String,String > maps=new HashMap<>();
        maps.put("productId",productId);
        maps.put("type",type);
        maps.put("catalogId",catalogId);
        maps.put("toUserId",toUserId);
        maps.put("amount",amount);
        maps.put("comment","充值");
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getMakeOrderBean(headerMap,maps)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MakeOrderBean>() {
                    @Override
                    public void accept(MakeOrderBean productListBean) throws Exception {
                        serializationCatalogReadView.getMakeOrderData(productListBean);
                    }
                });
    }
// 得到订单号
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
                        serializationCatalogReadView.showGetPayData(getPayDataBean);
                        Log.e("Sunny","+++++"+getPayDataBean.getData().getOrderSign());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Sunny","00000000000"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void actualView(SerializationCatalogReadContract.serializationCatalogReadView serializationCatalogReadView) {
        this.serializationCatalogReadView = serializationCatalogReadView;
    }

    @Override
    public void unActualView() {
        this.serializationCatalogReadView = null;
    }
}
