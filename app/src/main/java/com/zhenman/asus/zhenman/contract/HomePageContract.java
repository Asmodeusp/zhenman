package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;

public interface HomePageContract {
    interface HomePageInView{
//        头部信息
        void showHomePageHead(HomePageHeadBean homePageHeadBean);
    }
    interface HomePageInPresenter extends BasePresenter<HomePageInView>{
        void sendHomePageHeadData(String accessToken,String userId);

    }
}
