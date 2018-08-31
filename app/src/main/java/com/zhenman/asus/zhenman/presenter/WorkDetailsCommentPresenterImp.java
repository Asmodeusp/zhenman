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
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDY0MzMsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjY5MjM3ODlDRjhGQzJGOUE2OUQzQkFBMTU1QUMwQTRcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NzI0MjQzM30.MgRXQqZ-UXG6NyRU95PBpl2FQF84TjkU0bT-0bgXOMg");

        Map<String, String> map = new HashMap<>();
        map.put("pgcId", pgcId);
        map.put("pageNum", pageNum);
        map.put("pageSize", "20");
        RetrofitUtils.getInstance().getWorkDetailsCommentService().GetWorkDetailsCommentBean(Headermap,map).subscribeOn(Schedulers.newThread())
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
        Map<String, String> Headermap = new HashMap<>();
//        Headermap.put("accessToken", (String) SPUtils.get(App.context, SPKey.USER_TOKEN, ""));
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDY0MzMsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjY5MjM3ODlDRjhGQzJGOUE2OUQzQkFBMTU1QUMwQTRcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NzI0MjQzM30.MgRXQqZ-UXG6NyRU95PBpl2FQF84TjkU0bT-0bgXOMg");

        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("commentId", commentId);
        map.put("status", status);
        map.put("pgcId", pgcId);
        RetrofitUtils.getInstance().getWorkDetailsCommentService().GetPgcFabulousBean(Headermap, map).subscribeOn(Schedulers.newThread())
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
