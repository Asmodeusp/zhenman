package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.HomeHotBean;
import com.zhenman.asus.zhenman.model.bean.PgcReadFabulousBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;

public interface HomeHotContract {
    //首页热门View
    interface HomeHotView {
        void showError(String msg);
        void showHotBean(HomeHotBean homeHotBean);
        //Ugc点赞
        void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean);
        void showFollowBean(FollowBean followBean);
    }
    //首页热门Presenter
    interface HomeHotPresenter extends BasePresenter<HomeHotView> {
        void getHomeHotBean( String pageNum);
        //点赞  1 点赞   0 取消
        void UgcFabulous (String productId,String status);
        //关注  1 关注   0 取消
        void FollowUser (String followedUserId,String status);
    }

}
