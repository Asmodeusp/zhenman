package com.zhenman.asus.zhenman.presenter;


import com.zhenman.asus.zhenman.contract.SerializationCatalogReadContract;
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
import com.zhenman.asus.zhenman.model.service.SerializationCatalogReadService;
import com.zhenman.asus.zhenman.model.service.WorkCatalogService;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SerializationCatalogReadPresenterImp implements SerializationCatalogReadContract.serializationCatalogReadPresenter {
    SerializationCatalogReadContract.serializationCatalogReadView serializationCatalogReadView;

    @Override
    public void getSerializationCatalogReadBean(String catalogId) {
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getSerializationCatalogReadBean(catalogId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerializationCatalogReadBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(SerializationCatalogReadBean serializationCatalogReadBean) {
                        if (serializationCatalogReadBean.getState() == 0) {
                            serializationCatalogReadView.showError(serializationCatalogReadBean.getMsg());
                            serializationCatalogReadView.showserializationCatalogReadBean(serializationCatalogReadBean);
                        } else {
                            serializationCatalogReadView.showError(serializationCatalogReadBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getSerializationCatalogBean(String PgcId) {
        Map<String, String> map = new HashMap<>();
        map.put("pgcId", PgcId);
        RetrofitUtils.getInstance()
                .getService(SerializationCatalogReadService.class)
                .getSerializationCatalogBean(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerializationCatalogBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(SerializationCatalogBean serializationCatalogBean) {
                        if (serializationCatalogBean.getState() == 0) {

                            serializationCatalogReadView.showError(serializationCatalogBean.getMsg());
                            serializationCatalogReadView.showSerializationCatalogBean(serializationCatalogBean);
                        } else {
                            serializationCatalogReadView.showError(serializationCatalogBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //    创建订单
    @Override
    public void setMakeOrderData(String productId, String type, String catalogId, String amount, String comment) {
        Map<String, String> maps = new HashMap<>();
        maps.put("productId", productId);
        maps.put("type", type);
        maps.put("catalogId", catalogId);
        maps.put("amount", amount);
        maps.put("comment", "打赏");
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getMakeOrderBean(maps)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MakeOrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MakeOrderBean makeOrderBean) {
                        serializationCatalogReadView.getMakeOrderData(makeOrderBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //创建微信订单
    @Override
    public void setWxMakeOrderData(String productId, String type, String catalogId, String amount, String comment) {
        Map<String, String> maps = new HashMap<>();
        maps.put("productId", productId);
        maps.put("type", type);
        maps.put("catalogId", catalogId);
        maps.put("amount", amount);
        maps.put("comment", "打赏");
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getWxMakeOrderBean(maps)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MakeOrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MakeOrderBean makeOrderBean) {
                        serializationCatalogReadView.getWxMakeOrderData(makeOrderBean);
                    }

                    @Override
                    public void onError(Throwable e) {


                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    // 得到订单号
    @Override
    public void sendGetPayData(String orderSn) {
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getPayData(orderSn)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetPayDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetPayDataBean getPayDataBean) {
                        serializationCatalogReadView.showGetPayData(getPayDataBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //得到微信支付数据
    @Override
    public void sendGetWxPayData(String orderSn) {
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getWXPayData(orderSn)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayWeChatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PayWeChatBean payWeChatBean) {
                        if (payWeChatBean != null) {
                            serializationCatalogReadView.showGetWxPayData(payWeChatBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //    产品列表
    @Override
    public void sendProductListData(String type) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("type", type);//项目购买的有两种，茄子和茄子籽，两个产品列表都是这一个接口，区别就是type=1是请求茄子，type=2是请求茄子籽
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class)
                .getProductList(paramMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductListBean productListBean) {
                        if (productListBean.getMsg().equals(GetData.MSG_SUCCESS)) {
                            serializationCatalogReadView.showProductListBean(productListBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void PgcCollection(String productId, String status) {
        Map<String, String> map = new HashMap<>();
        map.put("productId", productId);
        map.put("status", status);
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class).GetPgcCollectionBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PgcCollectionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(PgcCollectionBean pgcCollectionBean) {
                        if (pgcCollectionBean.getState() == 0) {
                            serializationCatalogReadView.showError(pgcCollectionBean.getMsg());
                            serializationCatalogReadView.showPgcCollectionBean(pgcCollectionBean);
                        } else {
                            serializationCatalogReadView.showError(pgcCollectionBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCommentList(String id, String pageNum, String pageSize, String commentType, String commentSubType) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("commentType", commentType);
        map.put("commentSubType", commentSubType);
        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class).getCommentListBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CommentListBean commentListBean) {
                        if (commentListBean.getState() == 0) {
                            serializationCatalogReadView.showError(commentListBean.getMsg());
                            serializationCatalogReadView.showCommentListBean(commentListBean);
                        } else {
                            serializationCatalogReadView.showError(commentListBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRenewBean(String status, String pgcId) {
        Map<String, String> map = new HashMap<>();
        map.put("status", status);
        map.put("pgcId", pgcId);

        RetrofitUtils.getInstance().getService(SerializationCatalogReadService.class).GetRenewBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RenewBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RenewBean renewBean) {
                        if (renewBean.getState() == 0) {
                            serializationCatalogReadView.showError(renewBean.getMsg());
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void actualView(SerializationCatalogReadContract.serializationCatalogReadView serializationCatalogReadView) {
        this.serializationCatalogReadView = serializationCatalogReadView;
    }

    @Override
    public void unActualView() {
        this.serializationCatalogReadView = null;
    }
}
