package com.zhenman.asus.zhenman.presenter;


import com.zhenman.asus.zhenman.contract.WorkDetailsCommentContract;
import com.zhenman.asus.zhenman.model.bean.WorkDetailsCommentBean;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

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
        this.commentView =null;
    }

    @Override
    public void getWorkDetailsCommentBean(String pgcId, String pageNum) {

        Map<String, String> map = new HashMap<>();
        map.put("pgcId", pgcId);
        map.put("pageNum", pageNum);
        map.put("pageSize", "20");
        RetrofitUtils.getInstance().getWorkDetailsCommentService().GetWorkDetailsCommentBean( map).subscribeOn(Schedulers.newThread())
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

}
