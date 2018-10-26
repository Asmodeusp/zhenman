package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;
import com.zhenman.asus.zhenman.model.bean.WeiXinTiXianBean;

public interface SellEggplantContract {
    interface SellEggplantInView {
        void showError(String string);

        //        卖茄子
        void showSellEggplant(SellEggplantBean eggplantDetsBean);
//        微信提现|
        void showWeiXinTixian(WeiXinTiXianBean weiXinTiXianBean);
    }

    interface SellEggplantInPresenter extends BasePresenter<SellEggplantInView> {
        //        卖茄子
        void sendSellEggplant();
//        微信提现
        void sendWeixinTixian(String eggplantAmount,String biteEggplantAmount,String unripeEggplantAmount,String amount);
    }
}
