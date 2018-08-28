package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ClassifyBean;
import com.zhenman.asus.zhenman.model.bean.ClassifyTagBean;


public interface SerializationClassifyContract {
    interface SerializationClassifyView {
        void showError(String msg);
        //连载分类标签
        void showClassifyTagBean(ClassifyTagBean classifyTagBean);
        void showClassifyBean(ClassifyBean classifyBean);
    }

    interface SerializationClassifyPresenter extends BasePresenter<SerializationClassifyContract.SerializationClassifyView> {
        void getClassifyTagBean();
        void getClassifyBean(String pageNum,String pageSize,String statusTag,String subjectTag ,String backgroundTag,String typeTag );
    }
}
