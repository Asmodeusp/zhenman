package com.zhenman.asus.zhenman.presenter;


import android.util.Log;

import com.zhenman.asus.zhenman.contract.WorkDetailsCommentContract;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.service.SerializationCatalogReadService;
import com.zhenman.asus.zhenman.model.service.WorkDetailsCommentService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/**
 *            曰:
 *                   写字楼里写字间，写字间里程序员；
 *                   程序人员写程序，又拿程序换酒钱。
 *                   酒醒只在网上坐，酒醉还来网下眠；
 *                   酒醉酒醒日复日，网上网下年复年。
 *                   但愿老死电脑间，不愿鞠躬老板前；
 *                   奔驰宝马贵者趣，公交自行程序员。
 *                   别人笑我忒疯癫，我笑自己命太贱；
 *                   不见满街漂亮妹，哪个归得程序员？
*/

public class WorkDetailsCommentPresenterImp implements WorkDetailsCommentContract.WorkDetailsCommentPresenter {
    WorkDetailsCommentContract.WorkDetailsCommentView commentView;

    @Override
    public void actualView(WorkDetailsCommentContract.WorkDetailsCommentView workDetailsCommentView) {
        this.commentView = workDetailsCommentView;
    }

    @Override
    public void unActualView() {
        this.commentView = null;
    }

    @Override
    public void PGCFabulous(String productId, String commentId, String status, String pgcId) {

        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("commentId", commentId);
        map.put("status", status);
        map.put("pgcId", pgcId);
        RetrofitUtils.getInstance().getWorkDetailsCommentService().GetPgcFabulousBean( map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcFabulousBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PgcFabulousBean pgcFabulousBean) {
                        if (pgcFabulousBean.getState() == 0) {
                            commentView.showError(pgcFabulousBean.getMsg());
                            commentView.showPGCFabulousBean(pgcFabulousBean);
                        } else {
                            commentView.showError(pgcFabulousBean.getMsg());
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
                .getWorkDetailsCommentService()
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
                            commentView.showError(followBean.getMsg());
                            commentView.showFollowBean(followBean);
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
        RetrofitUtils.getInstance().getService(WorkDetailsCommentService.class).getCommentListBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CommentListBean commentListBean) {
                        if (commentListBean.getState() == 0) {
                            commentView.showError(commentListBean.getMsg());
                            commentView.showCommentListBean(commentListBean);
                        } else {
                            commentView.showError(commentListBean.getMsg());
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
