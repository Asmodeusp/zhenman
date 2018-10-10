package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.HomeAttentionContract;
import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.model.service.HomeAttentionService;
import com.zhenman.asus.zhenman.model.service.ThemeService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeAttentionPresenterImp implements HomeAttentionContract.HomeAttentionPresenter {
    HomeAttentionContract.HomeAttentionView homeAttentionView;

    @Override
    public void getHomeAttentionBean(String pageNum) {
        Map<String, String> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("pageSize", "20");
        RetrofitUtils.getInstance().getService(HomeAttentionService.class).GetHomeAttentionBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeAttentionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(HomeAttentionBean homeAttentionBean) {
                            homeAttentionView.showError(homeAttentionBean.getMsg());
                            homeAttentionView.showHomeAttentionBean(homeAttentionBean);

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
    public void UgcFabulous(String productId, String status) {
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("status", status);
        RetrofitUtils.getInstance().getService(HomeAttentionService.class).GetUgcFabulousBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UgcFabulousBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UgcFabulousBean ugcFabulousBean) {
                        if (ugcFabulousBean.getState() == 0) {
                            homeAttentionView.showError(ugcFabulousBean.getMsg());
                            homeAttentionView.showUgcFabulousBean(ugcFabulousBean);
                        } else {
                            homeAttentionView.showError(ugcFabulousBean.getMsg());
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
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("status", status);
        RetrofitUtils.getInstance().getService(HomeAttentionService.class).GetPgcCollectionBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcCollectionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PgcCollectionBean pgcCollectionBean) {
                        if (pgcCollectionBean.getState() == 0) {
                            homeAttentionView.showError(pgcCollectionBean.getMsg());
                            homeAttentionView.showPgcCollectionBean(pgcCollectionBean);
                        } else {
                            homeAttentionView.showError(pgcCollectionBean.getMsg());
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
    public void GetAttentionThemeData(String subjectId, String status) {
        HashMap<String, String> parmaMap = new HashMap<>();
        parmaMap.put("subjectId", subjectId);
        parmaMap.put("status", status);
        RetrofitUtils.getInstance().getService(HomeAttentionService.class)
                .GetThemeAttentionBean(parmaMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemeAttentionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ThemeAttentionBean themeAttentionBean) {


                        if (themeAttentionBean.getData() == null) {
                            homeAttentionView.showError("取消关注成功");
                        } else {
                            homeAttentionView.showAttentionTheme(themeAttentionBean);
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
    public void actualView(HomeAttentionContract.HomeAttentionView homeAttentionView) {
        this.homeAttentionView = homeAttentionView;
    }

    @Override
    public void unActualView() {
        this.homeAttentionView = null;
    }
}
