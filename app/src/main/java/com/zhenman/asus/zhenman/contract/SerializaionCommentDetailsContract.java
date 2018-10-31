package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.CommentItemListBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;

public interface SerializaionCommentDetailsContract {
    interface SerializaionCommentDetailsView{
        void showError(String msg);
        //点赞
        void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean);
        //子评论列表
        void showCommentItemList(CommentItemListBean commentItemListBean);
    }
    interface SerializaionCommentDetailsPresenter extends BasePresenter<SerializaionCommentDetailsContract.SerializaionCommentDetailsView> {
        //点赞  1 点赞   0 取消
        void PGCFabulous (String productId, String commentId,String status,String pgcId);
        /**
         * 章节评论
         * @param id             所有ID
         * @param pageNum
         * @param pageSize
         * @param commentType    1，UGCId 2.PGCID 3.章节ID 4.动态ID
         * @param commentSubType 1：主评论 2：子评论
         */
        void getCommentItemList(String id, String pageNum, String pageSize, String commentType, String commentSubType);
    }
}
