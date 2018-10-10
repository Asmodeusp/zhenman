package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;

public interface HomeAttentionContract {
    //首页热门View
    interface HomeAttentionView {
        void showError(String msg);
        void showHomeAttentionBean(HomeAttentionBean homeAttentionBean);
        //Ugc点赞
        void showUgcFabulousBean(UgcFabulousBean ugcFabulousBean);
        //Pgc点赞(收藏)
        void showPgcCollectionBean(PgcCollectionBean pgcCollectionBean);
        //主题点赞（收藏）
        void showAttentionTheme(ThemeAttentionBean themeAttentionBean);
    }
    //首页热门Presenter
    interface HomeAttentionPresenter extends BasePresenter<HomeAttentionContract.HomeAttentionView> {
        void getHomeAttentionBean( String pageNum);
        //1  ugc   2 pgc  3 主题
        //点赞  1 点赞   0 取消
        void UgcFabulous (String productId,String status);
        //Pgc点赞(收藏)  1 收藏   0 取消
        void PgcCollection (String productId,String status);
        //主题点赞（收藏） 0 关注 1 取消
        void GetAttentionThemeData(String subjectId, String status);
    }
}
