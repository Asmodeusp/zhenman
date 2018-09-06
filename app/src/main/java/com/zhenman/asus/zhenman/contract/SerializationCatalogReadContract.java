package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;

public interface SerializationCatalogReadContract {
    //连载页阅读View
    interface serializationCatalogReadView {
        void showError(String msg);
        void showSerializationDetailsBean(SerializationDetailsBean serializationDetailsBean);

        void showserializationCatalogReadBean(SerializationCatalogReadBean serializationCatalogReadBean);

        void showSerializationCatalogBean(SerializationCatalogBean serializationCatalogBean);
//        创建订单
        void getMakeOrderData(MakeOrderBean productListBean);
        //        创建微信订单
        void getWxMakeOrderData(MakeOrderBean productListBean);
        //        得到支付宝支付数据
        void showGetPayData(GetPayDataBean getPayDataBean);
        //得到作品章节下页对应的评论列表
        void showPgcChapterCommentListByOffSetBean(PgcChapterCommentListByOffSetBean pgcChapterCommentListByOffSetBean);
        //Pgc点赞
        void showPGCReadFabulousBean(PgcReadFabulousBean pgcReadFabulousBean);
        //        得到微信支付数据
        void showGetWxPayData(PayWeChatBean payWeChatBean);


    }

    //连载页阅读Presenter
    interface serializationCatalogReadPresenter extends BasePresenter<SerializationCatalogReadContract.serializationCatalogReadView> {
        void getSerializationCatalogReadBean(String catalogId);

        void getSerializationCatalogBean(String PgcId);

        void getSerializationDetailsBean(String PgcId);
        //        创建订单
        void setMakeOrderData(String productId, String type, String catalogId, String toUserId, String amount, String comment);
        //        创建微信订单
        void setWxMakeOrderData(String productId, String type, String catalogId, String toUserId, String amount, String comment);
        //        得到支付宝支付数据
        void sendGetPayData(String orderSn);
        //得到作品章节下页对应的评论列表
        void getPgcChapterCommentListByOffSetBean(String chapterId,String start,String end,String pageNum );
        //点赞  1 点赞   0 取消
        void PGCReadFabulous (String productId, String commentId,String status,String pgcId);
        //得到微信支付数据
        void sendGetWxPayData(String orderSn);

    }
}

