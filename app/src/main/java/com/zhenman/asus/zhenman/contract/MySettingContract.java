package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.CancelLoginBean;

public interface MySettingContract {
    interface MySettingInView{
//        注销登陆
        void showCancelLoginData(CancelLoginBean cancelLoginBean);
    }
    interface MySettingInPresenter extends BasePresenter<MySettingInView>{
//        注销登陆
        void  sendCancelLoginData(String mobile,String type,String otherUserId);
    }

}
