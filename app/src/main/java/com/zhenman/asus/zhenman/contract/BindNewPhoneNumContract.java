package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;

public interface BindNewPhoneNumContract {
    interface BindNewPhoneNumInView {
        //        更改手机号
        void showBindNewPhoneNumData(VerificationCodeBean verificationCodeBean);
        void showError(String string);
        //发送图片验证码到服务器得到短信验证码

        void showAlartPhoneNumData(VerificationCodeBean verificationCodeBean);
    }

    interface BindNewPhoneNumInPresenter extends BasePresenter<BindNewPhoneNumInView> {
        //        更改手机号
        void sendBindNewPhoneNumData(String mobile, String smsCode);
        //发送图片验证码到服务器得到短信验证码
        void sendAlartPhoneNumData(String mobile, String type, String imageCode);
    }
}
