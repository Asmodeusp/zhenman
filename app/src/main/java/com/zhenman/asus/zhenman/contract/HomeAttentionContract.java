package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;

public interface HomeAttentionContract {
    //首页热门View
    interface HomeAttentionView {
        void showError(String msg);
        void showHomeAttentionBean(HomeAttentionBean homeAttentionBean);
        //Ugc点赞
        void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean);

    }
    //首页热门Presenter
    interface HomeAttentionPresenter extends BasePresenter<HomeAttentionContract.HomeAttentionView> {
        void getHomeAttentionBean( String pageNum);

        //点赞  1 点赞   0 取消
        void UgcFabulous (String productId,String status);
    }
}
