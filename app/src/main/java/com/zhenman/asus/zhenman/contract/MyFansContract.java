package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.MyFansBean;

public interface MyFansContract {
    interface MyFansInView{
//        展示用户列表
        void showMyFansData(MyFansBean myFansBean);
        void showError(String string);
//        关注用户
        void showAttentionUser(AttentionMyFansBean verificationCodeBean);
    }
    interface MyFansInPresenter extends BasePresenter<MyFansInView>{
        //        展示用户列表
        void sendMyFansData(String pageNum,String pageSize);
//        关注用户
        void sendAttentionUserData(String followedUserId,String status);
    }
}
