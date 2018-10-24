package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;

public interface BuyEggplantContract {
    interface BuyEggplantInView{
        //        产品列表
        void showProductListBean(ProductListBean productListBean);
        void showError(String string);
        //        创建订单
        void getMakeOrderData(MakeOrderBean productListBean);

        //        创建微信订单
        void getWxMakeOrderData(MakeOrderBean productListBean);

        //        得到支付宝支付数据
        void showGetPayData(GetPayDataBean getPayDataBean);
        //        得到微信支付数据
        void showGetWxPayData(PayWeChatBean payWeChatBean);
    }interface BuyEggplantInPresenter extends BasePresenter<BuyEggplantInView>{
        //        发送产品列表数据
        void sendProductListData(String type);
        //创建支付宝订单
        void setMakeOrderData(String productId, String type, String amount, String comment);

        //创建微信订单
        void setWxMakeOrderData(String productId, String type, String amount, String comment);

        //得到支付宝支付数据
        void sendGetPayData(String orderSn);

        //得到微信支付数据
        void sendGetWxPayData(String orderSn);
    }
}
