package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.AccountManageContract;
import com.zhenman.asus.zhenman.model.bean.CancelLoginBean;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.model.service.AccountManagementService;
import com.zhenman.asus.zhenman.model.service.MySettingService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AccountManagePresenter implements AccountManageContract.AccountManageInPresenter {
    AccountManageContract.AccountManageInView accountManageInView;

    //    手机号绑定第三方
    @Override
    public void sendPhoneBindThirdData(String mobile, String otherUserId, String type, String name, String cityName, String headImg, String sex, String openId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mobile", mobile);
        paramMap.put("otherUserId", otherUserId);
        paramMap.put("type", type);
        paramMap.put("name", name);
        paramMap.put("cityName", cityName);
        paramMap.put("headImg", headImg);
        paramMap.put("sex", sex);
        paramMap.put("openId", openId);
        RetrofitUtils.getInstance().getService(AccountManagementService.class)
                .getPhoneBindThird(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationCodeBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            accountManageInView.showPhoneBindThirdData(verificationCodeBean);
                        } else {
                            accountManageInView.showError(verificationCodeBean.getMsg());
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

    //    第三方绑定第三方
    @Override
    public void sendThirdBindThirdData(String oauthId, String otherUserId, String type, String name) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("oauthId", oauthId);
        paramMap.put("otherUserId", otherUserId);
        paramMap.put("type", type);
        paramMap.put("name", name);
        RetrofitUtils.getInstance().getService(AccountManagementService.class)
                .getThirdBindThird(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationCodeBean verificationCodeBean) {
                        if (verificationCodeBean.getState() == 0) {
                            accountManageInView.showThirdBindThirdData(verificationCodeBean);
                        } else {
                            accountManageInView.showError(verificationCodeBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }//    注销登陆
    @Override
    public void sendCancelLoginData(String mobile, String type, String otherUserId) {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("mobile",mobile);
        paramsMap.put("type",type);
        paramsMap.put("otherUserId",otherUserId);
        RetrofitUtils.getInstance().getService(MySettingService.class)
                .getCancleLoginData(paramsMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CancelLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CancelLoginBean cancelLoginBean) {
                        accountManageInView.showCancelLoginData(cancelLoginBean);
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
    public void actualView(AccountManageContract.AccountManageInView accountManageInView) {
        this.accountManageInView = accountManageInView;
    }

    @Override
    public void unActualView() {
        this.accountManageInView = null;
    }
}
