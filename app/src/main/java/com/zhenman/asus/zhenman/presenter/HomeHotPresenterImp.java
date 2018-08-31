package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.contract.HomeHotContract;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeHotPresenterImp implements HomeHotContract.HomeHotPresenter {
    HomeHotContract.HomeHotView homeHotView;



    @Override
    public void actualView(HomeHotContract.HomeHotView homeHotView) {
        this.homeHotView = homeHotView;
    }

    @Override
    public void unActualView() {
        this.homeHotView = null;
    }

    @Override
    public void getHomeHotBean(String pageNum) {
        Map<String, String> Headermap = new HashMap<>();
        Headermap.put("accessToken", (String) SPUtils.get(App.context, SPKey.USER_TOKEN,""));
        Map<String, String> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("pageSize","20");
        RetrofitUtils.getInstance().getHomeHotService().GetHotBean(Headermap,map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeHotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(HomeHotBean userBean) {
                        if (userBean.getState() == 0) {
                            homeHotView.showError(userBean.getMsg());
                            homeHotView.showHotBean(userBean);
                        } else {
                            homeHotView.showError(userBean.getMsg());
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
