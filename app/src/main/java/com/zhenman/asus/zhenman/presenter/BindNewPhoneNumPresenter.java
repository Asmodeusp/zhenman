package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.BindNewPhoneNumContract;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.model.service.BindNewPhoneNumService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BindNewPhoneNumPresenter implements BindNewPhoneNumContract.BindNewPhoneNumInPresenter {
    BindNewPhoneNumContract.BindNewPhoneNumInView bindNewPhoneNumInView;

    @Override
    public void sendBindNewPhoneNumData(String mobile, String smsCode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mobile", mobile);
        paramMap.put("smsCode", smsCode);
        RetrofitUtils.getInstance().getService(BindNewPhoneNumService.class)
                .changeMobileNum(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationCodeBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            bindNewPhoneNumInView.showBindNewPhoneNumData(verificationCodeBean);
                        } else {
                            bindNewPhoneNumInView.showError(verificationCodeBean.getMsg());
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
//    发送图片验证码到服务器得到短信验证码
    @Override
    public void sendAlartPhoneNumData(String mobile, String type, String imageCode) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mobile",mobile);
        paramMap.put("type",type);
        paramMap.put("imageCode",imageCode);
        RetrofitUtils.getInstance().getService(BindNewPhoneNumService.class)
                .getSMSCodeBean(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationCodeBean verificationCodeBean) {
                        if (verificationCodeBean.getState()==0){
                            bindNewPhoneNumInView.showAlartPhoneNumData(verificationCodeBean);
                        }else {
                            bindNewPhoneNumInView.showError(verificationCodeBean.getMsg());
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
    public void actualView(BindNewPhoneNumContract.BindNewPhoneNumInView bindNewPhoneNumInView) {
        this.bindNewPhoneNumInView = bindNewPhoneNumInView;
    }

    @Override
    public void unActualView() {
        this.bindNewPhoneNumInView = null;
    }
}
