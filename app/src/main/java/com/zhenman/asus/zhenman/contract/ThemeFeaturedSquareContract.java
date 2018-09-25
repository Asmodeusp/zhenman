package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ThemeFeaturedBean;

public interface ThemeFeaturedSquareContract {
    interface ThemeFeaturedSquareInView {
        //展示主题详情
        void showThemeFeaturedSquareData(ThemeFeaturedBean themeFeaturedBean);

        void showError(String string);
    }

    interface ThemeFeaturedSquareInPresenter extends BasePresenter<ThemeFeaturedSquareInView> {
        void sendThemeFeaturedSquareData(String subjectId, String pageNum, String pageSize, String type);
    }
}
