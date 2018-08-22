package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.PgcFabulousBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;


public interface SerializationDetailsContract {
    interface SerializationDetailsView {
        void showError(String msg);
        //得到详情实体类
        void showSerializationDetailsBean(SerializationDetailsBean serializationDetailsBean);
        //得到章节实体类
        void showSerializationCatalogBean(SerializationCatalogBean serializationCatalogBean);
        //Pgc收藏
        void showPgcCollectionBean(PgcCollectionBean pgcCollectionBean);
        //Pgc点赞
        void showPGCFabulousBean(PgcFabulousBean pgcFabulousBean);
    }

    interface SerializationDetailsPresenter extends BasePresenter<SerializationDetailsContract.SerializationDetailsView> {
        //详情实体类
        void getSerializationDetailsBean(String PgcId);

        void getSerializationCatalogBean(String PgcId);
        //收藏  1 收藏   0 取消
        void PgcCollection (String productId,String status);
        //点赞  1 点赞   0 取消
        void PGCFabulous (String productId, String commentId,String status,String pgcId);

    }
}
