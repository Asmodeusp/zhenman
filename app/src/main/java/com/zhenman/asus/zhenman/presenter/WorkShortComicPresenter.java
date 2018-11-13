package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.WorkShortComicContract;
import com.zhenman.asus.zhenman.model.bean.WorkShortComicBean;
import com.zhenman.asus.zhenman.model.service.WorkShortComicService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WorkShortComicPresenter implements WorkShortComicContract.WorkShortComicInPresenter {
    WorkShortComicContract.WorkShortComicInView workShortComicInView;
    @Override
    public void sendWorkShortComic(String userId, String type, String pageNum, String pageSize) {
       Map<String, String> paramMap = new HashMap<>();
       paramMap.put("userId",userId);
       paramMap.put("type",type);
       paramMap.put("pageNum",pageNum);
       paramMap.put("pageSize",pageSize);
        RetrofitUtils.getInstance().getService(WorkShortComicService.class)
                .getWorkShortComicBean(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WorkShortComicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WorkShortComicBean workShortComicBean) {
                        if (workShortComicBean.getState()==0){
                            workShortComicInView.showWorkShortComic(workShortComicBean);
                        }else {
                            workShortComicInView.showError(workShortComicBean.getMsg());
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
    public void actualView(WorkShortComicContract.WorkShortComicInView workShortComicInView) {
            this.workShortComicInView=workShortComicInView;
    }

    @Override
    public void unActualView() {
        this.workShortComicInView=null;
    }
}
