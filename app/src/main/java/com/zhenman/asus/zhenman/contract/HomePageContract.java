package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;

public interface HomePageContract {
    interface HomePageInView {
        //        头部信息
        void showHomePageHead(HomePageHeadBean homePageHeadBean);

        //        关注用户
        void showAttentionUser(AttentionMyFansBean verificationCodeBean);

        void showError(String string);

        //        产品列表
        void showProductListBean(ProductListBean productListBean);

        //        创建订单
        void getMakeOrderData(MakeOrderBean productListBean);

        //        创建微信订单
        void getWxMakeOrderData(MakeOrderBean productListBean);

        //        得到支付宝支付数据
        void showGetPayData(GetPayDataBean getPayDataBean);
        //        得到微信支付数据
        void showGetWxPayData(PayWeChatBean payWeChatBean);

    }

    interface HomePageInPresenter extends BasePresenter<HomePageInView> {
        void sendHomePageHeadData(String userId);

        //        关注用户
        void sendAttentionUserData(String followedUserId, String status);

        //创建支付宝订单
        void setMakeOrderData(String productId, String type, String toUserId, String amount, String comment);

        //创建微信订单
        void setWxMakeOrderData(String productId, String type, String toUserId, String amount, String comment);

        //得到支付宝支付数据
        void sendGetPayData(String orderSn);

        //得到微信支付数据
        void sendGetWxPayData(String orderSn);

        //        发送产品列表数据
        void sendProductListData(String type);

    }
}
