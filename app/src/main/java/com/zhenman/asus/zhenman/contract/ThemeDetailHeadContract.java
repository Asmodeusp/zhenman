package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.model.bean.ThemeDetailHeadBean;

public interface ThemeDetailHeadContract {
    interface ThemeDetailHeadInView {
        //        获取主题详情头部
        void showThemeDetailHeadData(ThemeDetailHeadBean themeDetailHeadBean);
        void showError(String string);
        //        关注主题
        void showAttentionTheme(ThemeAttentionBean themeAttentionBean);

    }

    interface ThemeDetailHeadInPresenter extends BasePresenter<ThemeDetailHeadInView> {
        //       获取主题详情头部
        void sendThemeDetailHeadData(String subjectId);
//        关注主题
        void sendAttentionThemeData(String subjectId, String status);
    }
}
