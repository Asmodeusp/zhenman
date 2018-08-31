package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.GetMyDataBean;

public interface MySelfContract {
    interface MySelfInView{
//        得到个人资料
        void showGetMyData(GetMyDataBean getMyDataBean);
    }
    interface MySelfInPresenter extends BasePresenter<MySelfInView>{
//        得到个人资料
        void sendGetMyData(String accessToken,String oauthId);
    }

}
