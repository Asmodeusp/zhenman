package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.SerializationBean;
import com.zhenman.asus.zhenman.model.bean.SerializationLatelyBean;

public interface SerializationContract {
    interface SerializationView {
        void showError(String msg);
        void showSerializationBean(SerializationBean introducedBean);
        void showSerializationLatelyBean(SerializationLatelyBean serializationLatelyBean);
    }
    interface SerializationPresenter extends BasePresenter<SerializationContract.SerializationView> {
        void getSerializationBean( String userId);
        void getSerializationLatelyBean(String pageNum,String pageSize);
    }
}
