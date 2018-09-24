package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.SetPasswordContract;
import com.zhenman.asus.zhenman.model.bean.SetPasswordBean;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SetPasswordPresenterImp implements SetPasswordContract.SetPassWordPresenter {
    SetPasswordContract.SetPassWordView setPassWordView;

    @Override
    public void getRegisterLoginCode(String phone, String MSMCode, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("password", password);
        map.put("smsCode", MSMCode);
        RetrofitUtils.getInstance().getSetPasswordService()
                .GetSetPassWordBean(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SetPasswordBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SetPasswordBean setPasswordBean) {
                        if (setPasswordBean.getState() == 0) {
                            setPassWordView.showError(setPasswordBean.getMsg());
                            setPassWordView.gotoSetUserInfo();
                        } else {
                            setPassWordView.showError(setPasswordBean.getMsg());

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
    public void actualView(SetPasswordContract.SetPassWordView setPassWordView) {
        this.setPassWordView = setPassWordView;
    }

    @Override
    public void unActualView() {
        this.setPassWordView = null;
    }
}
