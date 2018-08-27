package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ClassifyTagBean;


public interface SerializationClassifyContract {
    interface SerializationClassifyView {
        void showError(String msg);
        //连载分类标签
        void showClassifyTagBean(ClassifyTagBean classifyTagBean);
    }

    interface SerializationClassifyPresenter extends BasePresenter<SerializationClassifyContract.SerializationClassifyView> {
        void getClassifyTagBean();
    }
}
