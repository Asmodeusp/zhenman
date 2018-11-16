package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.RenewBean;

public interface WorkCatalogContract {

    interface WorkCatalogView {
        void showError(String msg);
        //PGC评论列表
        void showRenewBean (RenewBean renewBean);
    }

    interface WorkCatalogPresenter extends BasePresenter<WorkCatalogContract.WorkCatalogView> {
        /**
         *
         * @param pgcId PgcID
         * @param status 1 开启  0 关闭
         */
        void getRenewBean(String status,String pgcId );
    }
}
