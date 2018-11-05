package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ByLikeBean;

public interface ByLikeContract {
    interface ByLikeInView {
        void showError(String string);

        void showByLikeData(ByLikeBean byLikeBean);
    }

    interface ByLikeInPresenter extends BasePresenter<ByLikeInView> {
        void sendByLikeData(String pageNum, String pageSize);
    }
}
