package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.ShelfHistoryContract;
import com.zhenman.asus.zhenman.model.bean.ShelfHistoryListBean;
import com.zhenman.asus.zhenman.model.service.ShelfHistoryListService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShelfHistoryPresenter implements ShelfHistoryContract.ShelfHistoryInPresenter {
    ShelfHistoryContract.ShelfHistoryInView shelfHistoryInView;
    @Override
    public void sendShelfHistoryData(String pageNum, String pageSize) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNum",pageNum);
        paramMap.put("pageSize",pageSize);
        RetrofitUtils.getInstance().getService(ShelfHistoryListService.class)
                .getShelfHistory(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShelfHistoryListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShelfHistoryListBean shelfHistoryListBean) {
if (shelfHistoryListBean.getState()==0){
    shelfHistoryInView.showShelfHistoryData(shelfHistoryListBean);
}else {
    shelfHistoryInView.showError(shelfHistoryListBean.getMsg());
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
    public void actualView(ShelfHistoryContract.ShelfHistoryInView shelfHistoryInView) {
        this.shelfHistoryInView=shelfHistoryInView;
    }

    @Override
    public void unActualView() {
        this.shelfHistoryInView=null;
    }
}
