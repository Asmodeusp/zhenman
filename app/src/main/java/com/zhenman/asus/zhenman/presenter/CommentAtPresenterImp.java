package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.CommentAtContract;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;
import com.zhenman.asus.zhenman.model.service.CommentAtService;
import com.zhenman.asus.zhenman.model.service.MyAttentionUserService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CommentAtPresenterImp implements CommentAtContract.CommentAtPresenter {
    CommentAtContract.CommentAtView commentAtView;


    @Override
    public void actualView(CommentAtContract.CommentAtView commentAtView) {
        this.commentAtView = commentAtView;
    }

    @Override
    public void unActualView() {
        this.commentAtView =null;
    }

    @Override
    public void sendMyAttentionUserData(String pageNum, String pageSize, String userId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);
        paramMap.put("userId", userId);
        RetrofitUtils.getInstance().getService(CommentAtService.class)
                .getMyAttentionUser(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyAttentionUserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyAttentionUserBean attentionUserBean) {
                        if (attentionUserBean.getState() == 0) {
                            commentAtView.showMyAttentionUserData(attentionUserBean);
                        } else {
                            commentAtView.showError(attentionUserBean.getMsg());
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
        Map<String, String> map = new HashMap<>();
        map.put("pgcId", PgcId);
        RetrofitUtils.getInstance().getSerializationDetailsService().GetSerializationDetailsBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerializationDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(SerializationDetailsBean userBean) {
                        if (userBean.getState() == 0) {
                            commentAtView.showError(userBean.getMsg());
                            commentAtView.showSerializationDetailsBean(userBean);
                        } else {
                            commentAtView.showError(userBean.getMsg());
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
