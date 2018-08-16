package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;

public interface LoginContract {
    //登陆View
    interface LoginView {
        void gotoContent();

        void showError(String msg);
    }

    //登陆Presenter
    interface LoginPresenter extends BasePresenter<LoginView> {
        void getLogin(String phone, String pageNum);
    }
}
