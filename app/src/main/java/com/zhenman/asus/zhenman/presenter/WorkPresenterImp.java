package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.WorkContract;
import com.zhenman.asus.zhenman.model.bean.HomeHotUgcCommentBean;
import com.zhenman.asus.zhenman.model.service.WorkService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WorkPresenterImp implements WorkContract.WorkPresenter {
    WorkContract.WorkView workView;

    @Override
    public void getHomeHotUgcCommentBean(String comicId, String pageNum, String pageSize, String type) {
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDY0MzMsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjY5MjM3ODlDRjhGQzJGOUE2OUQzQkFBMTU1QUMwQTRcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NzI0MjQzM30.MgRXQqZ-UXG6NyRU95PBpl2FQF84TjkU0bT-0bgXOMg");

        Map<String, String> map = new HashMap<>();
        map.put("comicId", comicId);
        map.put("pageNum", pageNum);
        map.put("pageSize", "20");
        map.put("type", type);
        RetrofitUtils.getInstance().getService(WorkService.class).GetHomeHotUgcCommentBean(Headermap,map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeHotUgcCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(HomeHotUgcCommentBean homeHotUgcCommentBean) {
                        if (homeHotUgcCommentBean.getState() == 0) {
                            workView.showError(homeHotUgcCommentBean.getMsg());
                            workView.ShowHomeHotUgcCommentBean(homeHotUgcCommentBean);
                        } else {
                            workView.showError(homeHotUgcCommentBean.getMsg());
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
    public void actualView(WorkContract.WorkView workView) {
        this.workView = workView;
    }

    @Override
    public void unActualView() {
        this.workView = null;
    }
}
