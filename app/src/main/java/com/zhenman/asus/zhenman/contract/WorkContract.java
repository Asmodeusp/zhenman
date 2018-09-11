package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.HomeHotUgcCommentBean;

public interface WorkContract {
    interface WorkView {
       void ShowHomeHotUgcCommentBean(HomeHotUgcCommentBean homeHotUgcCommentBean);
        void showError(String msg);
    }

    interface WorkPresenter extends BasePresenter<WorkContract.WorkView> {
        void getHomeHotUgcCommentBean(String comicId, String pageNum,String pageSize,String type);
    }
}
