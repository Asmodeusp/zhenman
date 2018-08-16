package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;

public interface SetPasswordContract {
    interface SetPassWordView {
        void gotoSetUserInfo();
        void showError(String msg);
    }

    interface SetPassWordPresenter extends BasePresenter<SetPasswordContract.SetPassWordView> {
        void getRegisterLoginCode(String phone,String MSMCode,String password);
    }
}
