package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.AlartDataBean;

public interface AlartDataContract {
    interface AlartDataInView{
        void showAlartData(AlartDataBean alartDataBean);
    }
    interface AlartDataInPresenter extends BasePresenter<AlartDataInView>{
        void sendAlartData(String accessToken,String oauthId,String sex,String name,String introduction
        ,String headImg,String birthdate);
    }
}
