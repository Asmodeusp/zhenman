package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;

public interface GetPayDataContract {
    interface GetPayDataInView{
        void showGetPayData(GetPayDataBean getPayDataBean);
    }
    interface GetPayDataInpresenter extends BasePresenter<GetPayDataInView>{
        void sendGetPayData(String orderSn);
    }
}
