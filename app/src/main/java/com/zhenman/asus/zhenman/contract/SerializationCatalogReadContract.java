package com.zhenman.asus.zhenman.contract;

import com.zhenman.asus.zhenman.base.BasePresenter;
import com.zhenman.asus.zhenman.model.bean.CommentListBean;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.PgcCollectionBean;
import com.zhenman.asus.zhenman.model.bean.PgcReadFabulousBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.model.bean.RenewBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogBean;
import com.zhenman.asus.zhenman.model.bean.SerializationCatalogReadBean;
import com.zhenman.asus.zhenman.model.bean.SerializationDetailsBean;

public interface SerializationCatalogReadContract {
    //连载页阅读View
    interface serializationCatalogReadView {
        void showError(String msg);
        //自动续购
        void showRenewBean (RenewBean renewBean);

        //PGC观看
        void showserializationCatalogReadBean(SerializationCatalogReadBean serializationCatalogReadBean);

        //PGC章节
        void showSerializationCatalogBean(SerializationCatalogBean serializationCatalogBean);

        //        产品列表
        void showProductListBean(ProductListBean productListBean);

        //        创建订单
        void getMakeOrderData(MakeOrderBean productListBean);

        //        创建微信订单
        void getWxMakeOrderData(MakeOrderBean productListBean);

        //        得到支付宝支付数据
        void showGetPayData(GetPayDataBean getPayDataBean);

        //得到作品章节下页对应的评论列表
        void showCommentListBean(CommentListBean commentListBean);

        //        得到微信支付数据
        void showGetWxPayData(PayWeChatBean payWeChatBean);

        //PGC收藏
        void showPgcCollectionBean(PgcCollectionBean collectionBean);


    }

    //连载页阅读Presenter
    interface serializationCatalogReadPresenter extends BasePresenter<SerializationCatalogReadContract.serializationCatalogReadView> {
        //PGC阅读
        void getSerializationCatalogReadBean(String catalogId);

        //PGC章节
        void getSerializationCatalogBean(String PgcId);

        //创建订单
        void setMakeOrderData(String productId, String type, String catalogId, String amount, String comment);

        //创建微信订单
        void setWxMakeOrderData(String productId, String type, String catalogId, String amount, String comment);

        //得到支付宝支付数据
        void sendGetPayData(String orderSn);


        //得到微信支付数据
        void sendGetWxPayData(String orderSn);

        //        发送产品列表数据
        void sendProductListData(String type);

        //收藏  1 收藏   0 取消
        void PgcCollection(String productId, String status);

        /**
         * 章节评论
         *
         * @param id             所有ID
         * @param pageNum
         * @param pageSize
         * @param commentType    1，UGCId 2.PGCID 3.章节ID 4.动态ID
         * @param commentSubType 1：主评论 2：子评论
         */
        void getCommentList(String id, String pageNum, String pageSize, String commentType, String commentSubType);
        /**
         *
         * @param pgcId PgcID
         * @param status 1 开启  0 关闭
         */
        void getRenewBean(String status,String pgcId );

    }
}

