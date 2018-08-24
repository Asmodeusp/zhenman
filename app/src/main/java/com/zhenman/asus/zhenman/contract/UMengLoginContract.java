package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.UMengLoginBean;

public interface UMengLoginContract {
    interface UMengLoginInView{
        void showUMengLoginData(UMengLoginBean uMengLoginBean);
    }
    interface UMengLoginInPresenter extends BasePresenter<UMengLoginContract.UMengLoginInView>{
        void sendUMengLoginData(String otherUserId,String name,String cityName,String headImg,String sex
        ,String type,String openId);
    }
}
