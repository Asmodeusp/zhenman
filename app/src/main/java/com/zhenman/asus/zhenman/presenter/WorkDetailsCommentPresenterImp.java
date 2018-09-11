package com.zhenman.asus.zhenman.presenter;


import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.contract.WorkDetailsCommentContract;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.WorkDetailsCommentBean;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
    public void getWorkDetailsCommentBean(String pgcId, String pageNum) {

        Map<String, String> map = new HashMap<>();
        map.put("pgcId", pgcId);
        map.put("pageNum", pageNum);
        map.put("pageSize", "20");
        RetrofitUtils.getInstance().getWorkDetailsCommentService().GetWorkDetailsCommentBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WorkDetailsCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(WorkDetailsCommentBean userBean) {
                        if (userBean.getState() == 0) {
                            commentView.showError(userBean.getMsg());
                            commentView.showWorkDetailsCommentBean(userBean);
                        } else {
                            commentView.showError(userBean.getMsg());
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

}
