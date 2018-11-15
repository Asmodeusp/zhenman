package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;

public interface AlartPhoneNumContract {
    interface AlartPhoneNumInView {
        //发送图片验证码到服务器得到短信验证码

        void showAlartPhoneNumData(VerificationCodeBean verificationCodeBean);

        //    账号绑定更换前的密码校验
        void showCheckCodeData(VerificationCodeBean verificationCodeBean);

        //        验证码无效
        void showError(String string);

        //        三方账号绑定手机号（手机未绑定过）
        void showThirdBindData(VerificationCodeBean verificationCodeBean);
    }

    interface AlartPhoneNumInPresenter extends BasePresenter<AlartPhoneNumInView> {
        //发送图片验证码到服务器得到短信验证码

        void sendAlartPhoneNumData(String mobile, String type, String imageCode);

        //    账号绑定更换前的密码校验
        void sendCheckCodeData(String mobile, String smsCode);

        //        三方账号绑定手机号（手机未绑定过）
        void sendThirdBindData(String mobile, String smsCode,String type,String oauthId);
    }
}
