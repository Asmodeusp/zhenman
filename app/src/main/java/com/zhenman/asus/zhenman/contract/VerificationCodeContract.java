package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;

public interface VerificationCodeContract {
    interface VerificationCodeView {
        void gotoPassword();
        void gotoLogin();
        void showError(String msg);
    }

    interface VerificationCodePresenter extends BasePresenter<VerificationCodeContract.VerificationCodeView> {
        void getVerificationCode(String phone, String ImageCode);
        void getRegisterLoginCode(String phone,String MSMCode);
    }
}
