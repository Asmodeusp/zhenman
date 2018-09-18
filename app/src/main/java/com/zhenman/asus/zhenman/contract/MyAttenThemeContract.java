package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.MyAttenThemeBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;

public interface MyAttenThemeContract {
    interface MyAttenThemeInView{
//        我关注的主题
        void showMyAttenTheme(MyAttenThemeBean myAttenThemeBean);
        void showError(String string);
        //        关注主题
        void showAttentionTheme(ThemeAttentionBean themeAttentionBean);
    }interface MyAttenThemeInPresenter extends BasePresenter<MyAttenThemeInView>{
//       我关注的主题
        void sendMyAttenThemeData(String otherUserId,String pageNum,String pageSize);
//        关注主题
        void sendAttentionThemeData(String subjectId,String status);

    }
}
