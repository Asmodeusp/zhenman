package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.FollowBean;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;

public interface WorkDisplayContract {
    interface workDisplayInView{
        //Ugc点赞
        void showPGCReadFabulousBean(UgcFabulousBean ugcFabulousBean);
        //PGC关注
        void showFollowBean(FollowBean followBean);
        //得到评论列表
        void showCommentList(CommentListBean commentListBean);
//        错误信息
        void showError(String string);
    }interface workDisplayInPresenter extends BasePresenter<workDisplayInView>{
        //点赞  1 点赞   0 取消
        void UgcFabulous (String productId,String status);
        //关注  1 关注   0 取消
        void FollowUser (String followedUserId,String status);
        /**
         * 章节评论
         * @param id             所有ID
         * @param pageNum
         * @param pageSize
         * @param commentType    1，UGCId 2.PGCID 3.章节ID 4.动态ID
         * @param commentSubType 1：主评论 2：子评论
         */
        void getCommentList(String id, String pageNum, String pageSize, String commentType, String commentSubType);
    }
}
