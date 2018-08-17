package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;

public interface PgcFabulousCantract {
    //PGC点赞View
    interface PGCFabulousView {
        void showError(String msg);
        void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean);
    }

    //PGC点赞Presenter
    interface PGCFabulousPresenter extends BasePresenter<PgcFabulousCantract.PGCFabulousView> {
        //点赞  1 点赞   0 取消
        void PGCFabulous (String productId, String commentId,String status,String pgcId);
    }
}
