package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.WorkDetailsCommentBean;

public interface WorkDetailsCommentContract {
    //首页热门View
    interface WorkDetailsCommentView {
        void showError(String msg);
        void showWorkDetailsCommentBean(WorkDetailsCommentBean workDetailsCommentBean);
    }
    //首页热门Presenter
    interface WorkDetailsCommentPresenter extends BasePresenter<WorkDetailsCommentContract.WorkDetailsCommentView> {
        void getWorkDetailsCommentBean( String pgcId,String pageNum);
    }
}
