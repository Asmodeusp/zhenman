package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.TheamBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;

public interface TheamBeanContract {
    interface TheamBeanInView {
        //        显示主题数据
        void showTheamBean(TheamBean theamBean);

        void showError(String string);

        //        关注主题
        void showAttentionTheme(ThemeAttentionBean themeAttentionBean);

    }

    interface TheamBeanInPresenter extends BasePresenter<TheamBeanInView> {
        void sendTheamBean();

        void sendAttentionThemeData(String subjectId, String status);
    }
}
