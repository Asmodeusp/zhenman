package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.PurchaseHistoryBean;

public interface PurchaseHistoryContract {
    interface PurchaseHistoryInView{
        void showPurchaseHistory(PurchaseHistoryBean purchaseHistoryBean);
    }
    interface PurchaseHistoryInPresenter extends BasePresenter<PurchaseHistoryInView>{
        void sendPurchaseHistory(String accessToken,String pageNum,String pageSize);
    }
}
