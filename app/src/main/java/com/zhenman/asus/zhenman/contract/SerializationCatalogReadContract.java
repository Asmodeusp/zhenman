package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;

public interface SerializationCatalogReadContract {
    //连载页阅读View
    interface serializationCatalogReadView {
        void showError(String msg);
        void showSerializationDetailsBean(SerializationDetailsBean serializationDetailsBean);

        void showserializationCatalogReadBean(SerializationCatalogReadBean serializationCatalogReadBean);

        void showSerializationCatalogBean(SerializationCatalogBean serializationCatalogBean);
    }
    //连载页阅读Presenter
    interface serializationCatalogReadPresenter extends BasePresenter<SerializationCatalogReadContract.serializationCatalogReadView> {
        void getSerializationCatalogReadBean(String catalogId);
        void getSerializationCatalogBean(String PgcId);
        void getSerializationDetailsBean(String PgcId);
    }
}

