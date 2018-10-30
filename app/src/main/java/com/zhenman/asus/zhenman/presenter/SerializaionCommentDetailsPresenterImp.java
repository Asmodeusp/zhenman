package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.SerializaionCommentDetailsContract;
import com.zhenman.asus.zhenman.model.bean.CommentItemListBean;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.service.SerializaionCommentDetailsService;
import com.zhenman.asus.zhenman.model.service.SerializationCatalogReadService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class SerializaionCommentDetailsPresenterImp implements SerializaionCommentDetailsContract.SerializaionCommentDetailsPresenter{
    SerializaionCommentDetailsContract.SerializaionCommentDetailsView pgcChapterCommentDetailView;


    @Override
    public void PGCFabulous(String productId, String commentId, String status, String pgcId) {
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("commentId", commentId);
        map.put("status", status);
        map.put("pgcId", pgcId);
        RetrofitUtils.getInstance().getService(SerializaionCommentDetailsService.class).GetPgcFabulousBean( map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcFabulousBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PgcFabulousBean pgcFabulousBean) {
                        if (pgcFabulousBean.getState() == 0) {
                            pgcChapterCommentDetailView.showError(pgcFabulousBean.getMsg());

                            pgcChapterCommentDetailView.showPGCFabulousBean(pgcFabulousBean);
                        } else {
                            pgcChapterCommentDetailView.showError(pgcFabulousBean.getMsg());
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
    public void getCommentItemList(String id, String pageNum, String pageSize, String commentType, String commentSubType) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("commentType", commentType);
        map.put("commentSubType", commentSubType);
        RetrofitUtils.getInstance().getService(SerializaionCommentDetailsService.class).getCommentListBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentItemListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CommentItemListBean commentListBean) {
                        if (commentListBean.getState() == 0) {
                            pgcChapterCommentDetailView.showError(commentListBean.getMsg());
                            pgcChapterCommentDetailView.showCommentItemList(commentListBean);
                        } else {
                            pgcChapterCommentDetailView.showError(commentListBean.getMsg());
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
    public void actualView(SerializaionCommentDetailsContract.SerializaionCommentDetailsView pgcChapterCommentDetailView) {
        this.pgcChapterCommentDetailView  = pgcChapterCommentDetailView;
    }

    @Override
    public void unActualView() {
        this.pgcChapterCommentDetailView = null;

    }
}
