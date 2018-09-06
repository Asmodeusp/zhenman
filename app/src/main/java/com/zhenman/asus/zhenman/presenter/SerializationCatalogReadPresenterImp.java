package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.contract.SerializationCatalogReadContract;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PgcChapterCommentListByOffSetBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.PgcReadFabulousBean;
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
//        Headermap.put("accessToken", (String) SPUtils.get(App.context, SPKey.USER_TOKEN,""));
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDY0MzMsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjY5MjM3ODlDRjhGQzJGOUE2OUQzQkFBMTU1QUMwQTRcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NzI0MjQzM30.MgRXQqZ-UXG6NyRU95PBpl2FQF84TjkU0bT-0bgXOMg");

        Map<String, String> map = new HashMap<>();

        map.put("catalogId", catalogId);
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getSerializationCatalogReadBean(Headermap, map)
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
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> map = new HashMap<>();
        map.put("pgcId", PgcId);
        RetrofitUtils.getInstance()
                .getService(SerializationCatalogReadService.class)
                .getSerializationCatalogBean(Headermap, map)
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
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> map = new HashMap<>();
        map.put("pgcId", PgcId);
        RetrofitUtils.getInstance().getSerializationDetailsService().GetSerializationDetailsBean(Headermap, map).subscribeOn(Schedulers.newThread())
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
    public void setMakeOrderData(final String productId, String type, String catalogId, String toUserId, String amount, String comment) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> maps = new HashMap<>();
        maps.put("productId", productId);
        maps.put("type", type);
        maps.put("catalogId", catalogId);
        maps.put("toUserId", toUserId);
        maps.put("amount", amount);
        maps.put("comment", "充值");
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getMakeOrderBean(headerMap, maps)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MakeOrderBean>() {
                    @Override
                    public void accept(MakeOrderBean productListBean) throws Exception {
                        if (productListBean!=null) {
                            serializationCatalogReadView.getMakeOrderData(productListBean);
                        }

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
                        Log.e("Sunny", "+++++" + getPayDataBean.getData().getOrderSign());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Sunny", "00000000000" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getPgcChapterCommentListByOffSetBean(String chapterId, String start, String end, String pageNum) {
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> map = new HashMap<>();
        map.put("chapterId", chapterId);
        map.put("start", start);
        map.put("end", end);
        map.put("pageNum", pageNum);
        map.put("pageSize", "60");
        RetrofitUtils.getInstance()
                .getService(SerializationCatalogReadService.class)
                .getPgcChapterCommentListByOffSetBean(Headermap, map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcChapterCommentListByOffSetBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PgcChapterCommentListByOffSetBean pgcChapterCommentListByOffSetBean) {
                        if (pgcChapterCommentListByOffSetBean.getState() == 0) {
                            serializationCatalogReadView.showError(pgcChapterCommentListByOffSetBean.getMsg());
                            serializationCatalogReadView.showPgcChapterCommentListByOffSetBean(pgcChapterCommentListByOffSetBean);
                        } else {
                            serializationCatalogReadView.showError(pgcChapterCommentListByOffSetBean.getMsg());
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
    public void PGCReadFabulous(String productId, String commentId, String status, String pgcId) {
        Map<String, String> Headermap = new HashMap<>();
//        Headermap.put("accessToken", (String) SPUtils.get(App.context, SPKey.USER_TOKEN, ""));
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("commentId", commentId);
        map.put("status", status);
        map.put("pgcId", pgcId);
        RetrofitUtils.getInstance()
                .getService(SerializationCatalogReadService.class)
                .GetPGCReadFabulousBean(Headermap, map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcReadFabulousBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PgcReadFabulousBean pgcReadFabulousBean) {
                        if (pgcReadFabulousBean != null) {
                            Log.e("12345",serializationCatalogReadView.toString());
                            serializationCatalogReadView.showError(pgcReadFabulousBean.getMsg());
                            serializationCatalogReadView.showPGCReadFabulousBean(pgcReadFabulousBean);
                            Log.e("123456",serializationCatalogReadView.toString());
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
    public void actualView(SerializationCatalogReadContract.serializationCatalogReadView serializationCatalogReadView) {
        if (serializationCatalogReadView!=null) {
            this.serializationCatalogReadView = serializationCatalogReadView;
        }
    }

    @Override
    public void unActualView() {
        if (serializationCatalogReadView!=null) {
            this.serializationCatalogReadView = null;
        }

    }
}
