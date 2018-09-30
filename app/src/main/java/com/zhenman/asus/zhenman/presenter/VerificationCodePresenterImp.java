package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.contract.VerificationCodeContract;
import com.zhenman.asus.zhenman.model.bean.RegisterLoginCodeBean;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VerificationCodePresenterImp implements VerificationCodeContract.VerificationCodePresenter {
    VerificationCodeContract.VerificationCodeView verificationCodeView;


    @Override
    public void actualView(VerificationCodeContract.VerificationCodeView verificationCodeView) {
        this.verificationCodeView = verificationCodeView;
    }

    @Override
    public void unActualView() {
            this.verificationCodeView =null;
    }

    @Override
    public void getVerificationCode(String phone, String ImageCode) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("type", "1");
        map.put("imageCode", ImageCode);
        RetrofitUtils.getInstance().getRegisterVerificationCodeService().GetVerificationCodeBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationCodeBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            verificationCodeView.showError(verificationCodeBean.getMsg());

                        } else {
                            verificationCodeView.showError(verificationCodeBean.getMsg());

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
    public void getRegisterLoginCode(String phone, String MSMCode) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("smsCode", MSMCode);
        RetrofitUtils.getInstance().getRegisterVerificationCodeService().GetRegisterLoginCodeBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterLoginCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterLoginCodeBean registerLoginCodeBean) {
                        Log.e("VerificationCodePresent", registerLoginCodeBean.getMsg());
                        if (registerLoginCodeBean.getState() == 0) {
                            verificationCodeView.showError(registerLoginCodeBean.getMsg());
                            verificationCodeView.gotoPassword();
                        } else {
                            verificationCodeView.showError(registerLoginCodeBean.getMsg());
                        }
                        if (registerLoginCodeBean.getState() == 1020) {
                            verificationCodeView.showError("账户已注册");
                            verificationCodeView.gotoLogin();
                        } else {
                            verificationCodeView.showError(registerLoginCodeBean.getMsg());

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
