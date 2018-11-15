package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.WorkDisplayContract;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;
import com.zhenman.asus.zhenman.model.service.WorkDisplayService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WorkDisplayPresenter implements WorkDisplayContract.workDisplayInPresenter {
    WorkDisplayContract.workDisplayInView workDisplayInView;

    @Override
    public void UgcFabulous(String productId, String status) {
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("status", status);
        RetrofitUtils.getInstance()
                .getService(WorkDisplayService.class)
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
                            workDisplayInView.showPGCReadFabulousBean(ugcFabulousBean);
                        }else {
                            workDisplayInView.showError(ugcFabulousBean.getMsg());
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
                .getService(WorkDisplayService.class)
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
                            workDisplayInView.showError(followBean.getMsg());
                            workDisplayInView.showFollowBean(followBean);
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
        RetrofitUtils.getInstance().getService(WorkDisplayService.class).getCommentListBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CommentListBean commentListBean) {
                        if (commentListBean.getState() == 0) {
                            workDisplayInView.showError(commentListBean.getMsg());
                            workDisplayInView.showCommentList(commentListBean);
                        } else {
                            workDisplayInView.showError(commentListBean.getMsg());
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
    public void actualView(WorkDisplayContract.workDisplayInView workDisplayInView) {
        this.workDisplayInView = workDisplayInView;

    }

    @Override
    public void unActualView() {
        this.workDisplayInView = null;
    }
}
