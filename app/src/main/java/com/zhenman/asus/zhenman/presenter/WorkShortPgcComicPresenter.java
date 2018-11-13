package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.WorkShortPgcComicContract;
import com.zhenman.asus.zhenman.model.bean.WorkShortPgcComicBean;
import com.zhenman.asus.zhenman.model.service.WorkShortPgcComicService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WorkShortPgcComicPresenter implements WorkShortPgcComicContract.WorkShortPgcComicInPresenter {
    WorkShortPgcComicContract.WorkShortPgcComicInView workShortPgcComicInView;

    @Override
    public void sendWorkShortPgcComic(String userId, String type, String pageNum, String pageSize) {

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("type", type);
        paramMap.put("pageNum", pageNum);
        paramMap.put("pageSize", pageSize);
        RetrofitUtils.getInstance().getService(WorkShortPgcComicService.class)
                .getWorkShortPgcComicBean(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WorkShortPgcComicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WorkShortPgcComicBean workShortPgcComicBean) {
                        if (workShortPgcComicBean.getState() == 0) {
                            workShortPgcComicInView.showWorkPgcComic(workShortPgcComicBean);
                        } else {
                            workShortPgcComicInView.showError(workShortPgcComicBean.getMsg());
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
    public void actualView(WorkShortPgcComicContract.WorkShortPgcComicInView workShortPgcComicInView) {
        this.workShortPgcComicInView = workShortPgcComicInView;
    }

    @Override
    public void unActualView() {
        this.workShortPgcComicInView = null;
    }
}
