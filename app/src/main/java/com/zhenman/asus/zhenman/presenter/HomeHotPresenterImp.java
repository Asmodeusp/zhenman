package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.HomeHotContract;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.model.service.HomeHotService;
import com.zhenman.asus.zhenman.model.service.SerializationCatalogReadService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeHotPresenterImp implements HomeHotContract.HomeHotPresenter {
    HomeHotContract.HomeHotView homeHotView;


    @Override
    public void actualView(HomeHotContract.HomeHotView homeHotView) {
        this.homeHotView = homeHotView;
    }

    @Override
    public void unActualView() {
        this.homeHotView = null;
    }

    @Override
    public void getHomeHotBean(String pageNum) {
        Map<String, String> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("pageSize", "10");
        RetrofitUtils.getInstance().getHomeHotService().GetHotBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeHotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(HomeHotBean homeHotBean) {

                        if (homeHotBean.getState() == 0) {
                            if (homeHotBean!=null) {
                                homeHotView.showHotBean(homeHotBean);
                            }

                        } else {
                            homeHotView.showError(homeHotBean.getMsg());
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
    public void UgcFabulous(String productId, String status) {
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("status", status);
        RetrofitUtils.getInstance()
                .getService(HomeHotService.class)
                .GetUgcFabulousBean(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UgcFabulousBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UgcFabulousBean ugcFabulousBean) {
                        if (ugcFabulousBean != null) {
                            homeHotView.showError(ugcFabulousBean.getMsg());
                            homeHotView.showPGCReadFabulousBean(ugcFabulousBean);
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
    public void FollowUser(String followedUserId, String status) {
        Map<String, String> map = new HashMap<>();
        map.put("followedUserId", followedUserId);
        map.put("status", status);
        RetrofitUtils.getInstance()
                .getService(HomeHotService.class)
                .GetFollowBean(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FollowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(FollowBean followBean) {
                        if (followBean != null) {
                            homeHotView.showError(followBean.getMsg());
                            homeHotView.showFollowBean(followBean);
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
    public void getCommentList(String id, String pageNum, String pageSize, String commentType, String commentSubType) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("commentType", commentType);
        map.put("commentSubType", commentSubType);
        RetrofitUtils.getInstance().getService(HomeHotService.class).getCommentListBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CommentListBean commentListBean) {
                        if (commentListBean.getState() == 0) {
                            homeHotView.showError(commentListBean.getMsg());
                            homeHotView.showCommentList(commentListBean);
                        } else {
                            homeHotView.showError(commentListBean.getMsg());
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
}
