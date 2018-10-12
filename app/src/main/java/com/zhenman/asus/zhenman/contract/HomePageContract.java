package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;

public interface HomePageContract {
    interface HomePageInView{
//        头部信息
        void showHomePageHead(HomePageHeadBean homePageHeadBean);
        //        关注用户
        void showAttentionUser(AttentionMyFansBean verificationCodeBean);
        void showError(String string);
    }
    interface HomePageInPresenter extends BasePresenter<HomePageInView>{
        void sendHomePageHeadData(String userId);
        //        关注用户
        void sendAttentionUserData(String followedUserId,String status);

    }
}
