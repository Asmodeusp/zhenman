package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;

import java.util.Map;

public interface MakeOrderContract {
    interface MakeOrderInView{
        void getProductListData(MakeOrderBean productListBean);
    }
    interface MakeOrderInPresenter extends BasePresenter<MakeOrderInView>{
        void setProductListData(String productId,String type,String catalogId,String toUserId,String amount);
    }
}
