package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.AlartPhoneNumContract;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.model.service.AlartPhoneNumService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AlartPhoneNumPresenter implements AlartPhoneNumContract.AlartPhoneNumInPresenter {
    AlartPhoneNumContract.AlartPhoneNumInView alartPhoneNumInView;

    @Override
    public void sendAlartPhoneNumData(String mobile, String type, String imageCode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mobile", mobile);
        paramMap.put("type", "1");
        paramMap.put("imageCode", "1234");

        RetrofitUtils.getInstance()
                .getService(AlartPhoneNumService.class)
                .GetSMSCodeBean(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationCodeBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            alartPhoneNumInView.showAlartPhoneNumData(verificationCodeBean);
                        } else {
                            alartPhoneNumInView.showError();
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
    //    账号绑定更换前的密码校验(更换的时候要用)
    @Override
    public void sendCheckCodeData(String mobile, String smsCode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mobile", mobile);
        paramMap.put("smsCode", smsCode);
        RetrofitUtils.getInstance().getService(AlartPhoneNumService.class)
                .checkCodeBean(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationCodeBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            alartPhoneNumInView.showCheckCodeData(verificationCodeBean);
                        } else {
                            alartPhoneNumInView.showError();
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

    //        三方账号绑定手机号（手机未绑定过）
    @Override
    public void sendThirdBindData(String mobile, String smsCode,String type,String oauthId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mobile",mobile);
        paramMap.put("smsCode",smsCode);
        paramMap.put("type",type);
        paramMap.put("oauthId",oauthId);
        RetrofitUtils.getInstance().getService(AlartPhoneNumService.class)
                .replacePhoneNum(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationCodeBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            alartPhoneNumInView.showThirdBindData(verificationCodeBean);
                        } else {
                            alartPhoneNumInView.showError();
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
    public void actualView(AlartPhoneNumContract.AlartPhoneNumInView alartPhoneNumInView) {
        this.alartPhoneNumInView = alartPhoneNumInView;
    }

    @Override
    public void unActualView() {
        this.alartPhoneNumInView = null;
    }
}
