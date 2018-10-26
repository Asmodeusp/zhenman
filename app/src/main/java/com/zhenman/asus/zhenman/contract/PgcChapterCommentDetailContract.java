package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;

public interface PgcChapterCommentDetailContract {
    interface PgcChapterCommentDetailView{
        void showError(String msg);
        //点赞
        void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean);
    }
    interface PgcChapterCommentDetailPresenter extends BasePresenter<PgcChapterCommentDetailContract.PgcChapterCommentDetailView> {
        //点赞  1 点赞   0 取消
        void PGCFabulous (String productId, String commentId,String status,String pgcId);
    }
}
