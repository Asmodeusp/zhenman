package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;

public interface MyAttentionUserContract {
    interface MyAttentionUserInView{
//        用户的关注
        void showMyAttentionUserData(MyAttentionUserBean attentionUserBean);
//        展示错误信息
        void showError(String string);
        //        关注用户
        void showAttentionUser(AttentionMyFansBean verificationCodeBean);
    }
    interface MyAttentionUserInPresenter extends BasePresenter<MyAttentionUserInView>{
//        用户的关注
        void sendMyAttentionUserData(String pageNum,String pageSize,String userId);
        //        关注用户
        void sendAttentionUserData(String followedUserId,String status);
    }
}
