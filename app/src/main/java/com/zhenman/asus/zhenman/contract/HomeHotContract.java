package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
public interface HomeHotContract {
    //首页热门View
    interface HomeHotView {
        void showError(String msg);
        void showHotBean(HomeHotBean homeHotBean);
    }
    //首页热门Presenter
    interface HomeHotPresenter extends BasePresenter<HomeHotView> {
        void getHomeHotBean( String pageNum);
    }
}
