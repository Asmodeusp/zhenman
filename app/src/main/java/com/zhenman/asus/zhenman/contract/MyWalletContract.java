package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;

public interface MyWalletContract {
    interface SellEggplantInView {
        void showError(String string);

        //        卖茄子
        void showSellEggplant(SellEggplantBean eggplantDetsBean);
    }

    interface SellEggplantInPresenter extends BasePresenter<SellEggplantInView> {
        //        卖茄子
        void sendSellEggplant();
    }
}
