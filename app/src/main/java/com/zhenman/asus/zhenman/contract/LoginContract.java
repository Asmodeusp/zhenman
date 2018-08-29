package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ThirdPartyLoginBean;
import com.zhenman.asus.zhenman.model.bean.UMengLoginBean;

public interface LoginContract {
    //登陆View
    interface LoginView {
        void gotoContent();
//        展示用户友盟登陆的数据
        void showUMengLoginData(ThirdPartyLoginBean uMengLoginBean);

        void showError(String msg);
    }

    //登陆Presenter
    interface LoginPresenter extends BasePresenter<LoginView> {
        //        用户手机号登陆
        void getLogin(String phone, String pageNum);

        //    友盟第三方登录
        void sendUMengLoginData(String otherUserId, String name, String cityName, String headImg, String sex
                , String type, String openId);
    }
}
