package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.SerializationClassifyContract;
import com.zhenman.asus.zhenman.model.bean.ClassifyTagBean;
import com.zhenman.asus.zhenman.model.service.SerializationClassifyService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SerializationClassifyPresenterImp implements SerializationClassifyContract.SerializationClassifyPresenter {
    SerializationClassifyContract.SerializationClassifyView serializationClassifyView ;
    @Override
    public void getClassifyTagBean() {
        RetrofitUtils.getInstance().getService(SerializationClassifyService.class).GetClassifyTagBean().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClassifyTagBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ClassifyTagBean classifyTagBean) {
                        if (classifyTagBean.getState() == 0) {
                            serializationClassifyView.showError(classifyTagBean.getMsg());
                            serializationClassifyView.showClassifyTagBean(classifyTagBean);
                        } else {
                            serializationClassifyView.showError(classifyTagBean.getMsg());
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
    public void actualView(SerializationClassifyContract.SerializationClassifyView serializationClassifyView) {
        this.serializationClassifyView = serializationClassifyView;

    }

    @Override
    public void unActualView() {
        this.serializationClassifyView = null;


    }
}
