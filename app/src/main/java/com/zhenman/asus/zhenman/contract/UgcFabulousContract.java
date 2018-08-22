package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.UgcFabulousBean;

public interface UgcFabulousContract {
    //PGC点赞View
    interface UgcFabulousView {
        void showError(String msg);
        void showUgcFabulousBean(UgcFabulousBean ugcFabulousBean);
    }

    //PGC点赞Presenter
    interface UgcFabulousPresenter extends BasePresenter<UgcFabulousContract.UgcFabulousView> {
        //点赞  1 点赞   0 取消
        void UgcFabulous (String productId, String status);
    }
}
