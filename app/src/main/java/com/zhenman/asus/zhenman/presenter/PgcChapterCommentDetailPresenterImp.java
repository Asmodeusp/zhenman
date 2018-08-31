package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.PgcChapterCommentDetailContract;
import com.zhenman.asus.zhenman.model.bean.ClassifyBean;
import com.zhenman.asus.zhenman.model.bean.PgcChapterCommentDetailBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.service.PgcChapterCommentDetailService;
import com.zhenman.asus.zhenman.model.service.SerializationClassifyService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class PgcChapterCommentDetailPresenterImp  implements PgcChapterCommentDetailContract.PgcChapterCommentDetailPresenter{
    PgcChapterCommentDetailContract.PgcChapterCommentDetailView pgcChapterCommentDetailView;
    @Override
    public void GetPgcChapterCommentDetailBean(String pcciId, String pageNum, String pageSize, String pgcId) {
        Map<String, String> map = new HashMap<>();
        map.put("pcciId", pcciId);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("pgcId", pgcId);
        RetrofitUtils.getInstance().getService(PgcChapterCommentDetailService.class)
                .getPgcChapterCommentDetailBean(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcChapterCommentDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(PgcChapterCommentDetailBean pgcChapterCommentDetailBean) {
                        if (pgcChapterCommentDetailBean.getState() == 0) {
                            Log.e("qqqqqqqqqqqq",pgcChapterCommentDetailBean.getMsg());
                            pgcChapterCommentDetailView.showError(pgcChapterCommentDetailBean.getMsg());
                            pgcChapterCommentDetailView.showPgcChapterCommentDetailBean(pgcChapterCommentDetailBean);
                        } else {
                            pgcChapterCommentDetailView.showError(pgcChapterCommentDetailBean.getMsg());
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
        RetrofitUtils.getInstance().getService(PgcChapterCommentDetailService.class).GetPgcFabulousBean(Headermap, map).subscribeOn(Schedulers.newThread())
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
    public void actualView(PgcChapterCommentDetailContract.PgcChapterCommentDetailView pgcChapterCommentDetailView) {
        this.pgcChapterCommentDetailView  = pgcChapterCommentDetailView;
    }

    @Override
    public void unActualView() {
        this.pgcChapterCommentDetailView = null;

    }
}
