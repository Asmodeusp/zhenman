package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.EggplantDetailsBean;

public interface EggplantDetailsContract {
    interface EggplantDetailsInView{
        void showError(String string);//错误信息
//        展示茄子明细记录
        void showEggplantDetailsData(EggplantDetailsBean eggplantDetailsBean);
    }
    interface EggplantDetailsInPresenter extends BasePresenter<EggplantDetailsInView>{
        void sendEggplantDetailsData(String pageNum,String pageSize);
    }
}
