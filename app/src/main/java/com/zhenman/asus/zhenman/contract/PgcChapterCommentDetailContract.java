package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.PgcChapterCommentDetailBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;

public interface PgcChapterCommentDetailContract {
    interface PgcChapterCommentDetailView{
        void showError(String msg);
        //点赞
        void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean);
        //作评主评论下的列表
        void showPgcChapterCommentDetailBean(PgcChapterCommentDetailBean pgcChapterCommentDetailBean);
    }
    interface PgcChapterCommentDetailPresenter extends BasePresenter<PgcChapterCommentDetailContract.PgcChapterCommentDetailView> {
        //作评主评论下的列表
        void GetPgcChapterCommentDetailBean(String pcciId,String pageNum,String pageSize,String pgcId);
        //点赞  1 点赞   0 取消
        void PGCFabulous (String productId, String commentId,String status,String pgcId);
    }
}
