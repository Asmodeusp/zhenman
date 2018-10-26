package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;

public interface WorkDetailsCommentContract {
    //首页热门View
    interface WorkDetailsCommentView {
        void showError(String msg);
        //Pgc点赞
        void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean);
        //PGC关注
        void showFollowBean(FollowBean followBean);
        //PGC评论列表
        void showCommentListBean (CommentListBean commentListBean);
    }
    //首页热门Presenter
    interface WorkDetailsCommentPresenter extends BasePresenter<WorkDetailsCommentContract.WorkDetailsCommentView> {
        //点赞  1 点赞   0 取消
        void PGCFabulous (String productId, String commentId,String status,String pgcId);
        //关注  1 关注   0 取消
        void FollowUser (String followedUserId,String status);
        //PGC评论列表

        /**
         *
         * @param id  所有ID
         * @param pageNum
         * @param pageSize
         * @param commentType  1，UGCId 2.PGCID 3.章节ID 4.动态ID
         * @param commentSubType 1.主评论，2子评论
         */
        void getCommentList(String id,String pageNum,String pageSize,String commentType, String commentSubType );
    }
}
