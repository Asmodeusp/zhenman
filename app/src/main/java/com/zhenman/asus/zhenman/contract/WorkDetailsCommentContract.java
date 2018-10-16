package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.WorkDetailsCommentBean;

public interface WorkDetailsCommentContract {
    //首页热门View
    interface WorkDetailsCommentView {
        void showError(String msg);
        void showWorkDetailsCommentBean(WorkDetailsCommentBean workDetailsCommentBean);
        //Pgc点赞
        void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean);
        //PGC关注
        void showFollowBean(FollowBean followBean);
    }
    //首页热门Presenter
    interface WorkDetailsCommentPresenter extends BasePresenter<WorkDetailsCommentContract.WorkDetailsCommentView> {
        void getWorkDetailsCommentBean( String pgcId,String pageNum);
        //点赞  1 点赞   0 取消
        void PGCFabulous (String productId, String commentId,String status,String pgcId);
        //关注  1 关注   0 取消
        void FollowUser (String followedUserId,String status);
    }
}
