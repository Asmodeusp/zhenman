package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;

public interface MySelfContract {
    interface MySelfInView{
//        得到个人资料
//        void showGetMyData(GetMyDataBean getMyDataBean);
        //        头部信息
        void showMySelfHead(HomePageHeadBean homePageHeadBean);
    }
    interface MySelfInPresenter extends BasePresenter<MySelfInView>{
//        得到个人资料
//        void sendGetMyData(String oauthId);

        void sendMyselfHeadData(String userId);
    }

}
