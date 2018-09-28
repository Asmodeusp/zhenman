package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.CancelLoginBean;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;

public interface AccountManageContract {
    interface AccountManageInView {
        //        手机号绑定第三方
        void showPhoneBindThirdData(VerificationCodeBean verificationCodeBean);

        //        第三方账号绑定第三方账号
        void showThirdBindThirdData(VerificationCodeBean verificationCodeBean);

        //        手机号解绑
        void showCancelLoginData(CancelLoginBean cancelLoginBean);

        void showError(String string);

    }

    interface AccountManageInPresenter extends BasePresenter<AccountManageInView> {
        //        手机号绑定第三方
        void sendPhoneBindThirdData(String mobile, String otherUserId, String type, String name, String cityName, String headImg, String sex, String openId);

        //        第三方账号绑定第三方账号
        void sendThirdBindThirdData(String oauthId, String otherUserId, String type, String name);

        //        手机号解绑
        void sendCancelLoginData(String mobile, String type, String otherUserId);

    }
}
