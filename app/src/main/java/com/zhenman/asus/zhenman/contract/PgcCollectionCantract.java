package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;

public interface PgcCollectionCantract {
    //PGC收藏View
    interface PgcCollectionView {
        void showError(String msg);
        void showPgcCollectionBean(PgcCollectionBean pgcCollectionBean);
    }

    //PGC收藏Presenter
    interface PgcCollectionPresenter extends BasePresenter<PgcCollectionCantract.PgcCollectionView> {
        //点赞  1 收藏   0 取消
        void PgcCollection (String productId,String status);
    }
}
