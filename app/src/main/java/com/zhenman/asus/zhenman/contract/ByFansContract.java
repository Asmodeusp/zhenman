package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.ByFansBean;

public interface ByFansContract {
    interface ByFansInView{
//        展示错误信息
        void showError(String string);
//       展示粉丝列表
        void showByFansData(ByFansBean byFansBean);
        //        关注用户
        void showAttentionUser(AttentionMyFansBean verificationCodeBean);
    }
    interface ByFansInPresenter extends BasePresenter<ByFansInView>{
        //展示粉丝列表
        void sendByFansData(String pageNum,String pageSize);
        //        关注用户
        void sendAttentionUserData(String followedUserId,String status);
    }
}
