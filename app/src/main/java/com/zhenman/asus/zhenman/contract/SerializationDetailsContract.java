package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;


public interface SerializationDetailsContract {
    interface SerializationDetailsView {
        void showError(String msg);

        void showSerializationDetailsBean(SerializationDetailsBean serializationDetailsBean);

        void showSerializationCatalogBean(SerializationCatalogBean serializationCatalogBean);

    }

    interface SerializationDetailsPresenter extends BasePresenter<SerializationDetailsContract.SerializationDetailsView> {
        void getSerializationDetailsBean(String PgcId);

        void getSerializationCatalogBean(String PgcId);

    }
}
