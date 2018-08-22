package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.SerializationDetailsContract;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SerializationDetailsPresenterImp implements SerializationDetailsContract.SerializationDetailsPresenter {
    SerializationDetailsContract.SerializationDetailsView serializationDetailsView;

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
                            serializationDetailsView.showError(userBean.getMsg());
                            serializationDetailsView.showSerializationDetailsBean(userBean);
                        } else {
                            serializationDetailsView.showError(userBean.getMsg());
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
        RetrofitUtils.getInstance().getSerializationDetailsService().GetSerializationCatalogBean(Headermap,map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerializationCatalogBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(SerializationCatalogBean userBean) {
                        if (userBean.getState() == 0) {
                            serializationDetailsView.showError(userBean.getMsg());
                            serializationDetailsView.showSerializationCatalogBean(userBean);
                        } else {
                            serializationDetailsView.showError(userBean.getMsg());
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
    public void PgcCollection(String productId, String status) {
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("status", status);
        RetrofitUtils.getInstance().getSerializationDetailsService().GetPgcCollectionBean(Headermap,map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcCollectionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(PgcCollectionBean pgcCollectionBean) {
                        if (pgcCollectionBean.getState() == 0) {
                            serializationDetailsView.showError(pgcCollectionBean.getMsg());
                            serializationDetailsView.showPgcCollectionBean(pgcCollectionBean);
                        } else {
                            serializationDetailsView.showError(pgcCollectionBean.getMsg());
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
    public void PGCFabulous(String productId, String commentId, String status, String pgcId) {
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MDQyMTAsInN1YiI6IntcInVzZXJJZFwiOjI1NSxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMTNEMUE1RjUxNDM1QURBODNFMkJFNUJDNzUzOTc0OTFcIixcInVzZXJBZ2VudFwiOlwiWk1DYXJ0b29uLzEuMCAoaVBob25lOyBpT1MgMTEuMC4zOyBTY2FsZS8yLjAwKVwiLFwiaW5kZXhcIjowLFwicmVmcmVzaFRva2VuXCI6ZmFsc2V9IiwiZXhwIjoxNTY0MDQwMjEwfQ.URYD_U8GudpDBWgllZewA6wex_CN16hHHzgq1LZA3KI");
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("commentId", commentId);
        map.put("status", status);
        map.put("pgcId", pgcId);
        RetrofitUtils.getInstance().getSerializationDetailsService().GetPgcFabulousBean(Headermap,map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcFabulousBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PgcFabulousBean pgcFabulousBean) {
                        if (pgcFabulousBean.getState() == 0) {
                            serializationDetailsView.showError(pgcFabulousBean.getMsg());
                            serializationDetailsView.showPGCFabulousBean(pgcFabulousBean);
                        } else {
                            serializationDetailsView.showError(pgcFabulousBean.getMsg());
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
    public void actualView(SerializationDetailsContract.SerializationDetailsView serializationDetailsView) {
        this.serializationDetailsView = serializationDetailsView;
    }

    @Override
    public void unActualView() {
        this.serializationDetailsView = null;
    }
}
