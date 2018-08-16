package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.SerializationContract;
import com.zhenman.asus.zhenman.model.bean.SerializationBean;
import com.zhenman.asus.zhenman.model.bean.SerializationLatelyBean;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SerializationPresenterImp implements SerializationContract.SerializationPresenter {
    SerializationContract.SerializationView introducedView;
    @Override
    public void actualView(SerializationContract.SerializationView serializationView) {
        this.introducedView = serializationView;
    }

    @Override
    public void unActualView() {
        this.introducedView = null;

    }

    @Override
    public void getSerializationBean(String userId) {
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        RetrofitUtils.getInstance().getSerializationService().GetSerializationBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerializationBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(SerializationBean introducedBean) {
                        if (introducedBean.getState() == 0) {
                            introducedView.showError(introducedBean.getMsg());
                            introducedView.showSerializationBean(introducedBean);
                        } else {
                            introducedView.showError(introducedBean.getMsg());
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
    public void getSerializationLatelyBean(String pageNum, String pageSize) {
        Map<String, String> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        RetrofitUtils.getInstance().getSerializationService().GetSerializationLatelyBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerializationLatelyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(SerializationLatelyBean introducedBean) {
                        if (introducedBean.getState() == 0) {
                            introducedView.showError(introducedBean.getMsg());
                            introducedView.showSerializationLatelyBean(introducedBean);
                        } else {
                            introducedView.showError(introducedBean.getMsg());
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
