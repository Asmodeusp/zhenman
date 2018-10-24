package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.BuyEggplantContract;
import com.zhenman.asus.zhenman.model.bean.GetPayDataBean;
import com.zhenman.asus.zhenman.model.bean.MakeOrderBean;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.model.bean.ProductListBean;
import com.zhenman.asus.zhenman.presenter.BuyEggplantPresenter;
import com.zhenman.asus.zhenman.utils.PayUtils;
import com.zhenman.asus.zhenman.view.adapter.serialization.ProductListAdapter;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class BuyEggplantActivity extends BaseActivity<BuyEggplantPresenter> implements BuyEggplantContract.BuyEggplantInView, ProductListAdapter.ProductListCallback {

    @BindView(R.id.app_back)
    AutoRelativeLayout appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.app_otherID)
    TextView appOtherID;
    @BindView(R.id.app_otherImage)
    ImageView appOtherImage;
    @BindView(R.id.buyEggplant_productList)
    RecyclerView buyEggplantProductList;
    @BindView(R.id.buyEggplant_zhifubaoBtn)
    CheckBox buyEggplantZhifubaoBtn;
    @BindView(R.id.buyEggplant_weixinBtn)
    CheckBox buyEggplantWeixinBtn;
    @BindView(R.id.buyEggplant_payBtn)
    Button buyEggplantPayBtn;
    @BindView(R.id.buyEggplant_RechargeAgreement)
    TextView buyEggplantRechargeAgreement;
    //支付产品Id
    private int qieziId;
    //    打赏价格
    private int qieziMoney;
    //    支付方式
    private String paymentMethod = "2";
    //订单数量
    private String orderNumber;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_eggplant;
    }

    @Override
    protected void init() {
        appTitle.setText("购买茄子籽");
        appOtherImage.setVisibility(View.VISIBLE);
        appOtherImage.setImageResource(R.mipmap.common_service);
        presenter.sendProductListData("2");
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.app_back, R.id.app_otherImage, R.id.buyEggplant_payBtn, R.id.buyEggplant_RechargeAgreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_back:
                finish();
                break;
            case R.id.app_otherImage:

                break;
            case R.id.buyEggplant_payBtn:
                if (paymentMethod.equals("1")) {
                    presenter.setWxMakeOrderData(qieziId + "", "1", "0.1", "充值");
                } else if (paymentMethod.equals("2")) {
                    presenter.setMakeOrderData(qieziId + "", "1", "0.1", "充值");
                } else {
                    Toast.makeText(BuyEggplantActivity.this, "请选择支付方式", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buyEggplant_RechargeAgreement:

                break;
        }
    }

    @Override
    public void showProductListBean(ProductListBean productListBean) {
        if (productListBean.getData().size() == 0) {
            Toast.makeText(this, "为获取到产品列表", Toast.LENGTH_SHORT).show();
        } else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            buyEggplantProductList.setLayoutManager(gridLayoutManager);
            ProductListAdapter productListAdapter = new ProductListAdapter(productListBean.getData(), this);
            buyEggplantProductList.setAdapter(productListAdapter);
            productListAdapter.ProductListCallback(this);
        }
    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMakeOrderData(MakeOrderBean productListBean) {
        if (productListBean.getData().getOrderNumber() != null) {
            orderNumber = productListBean.getData().getOrderNumber();
            presenter.sendGetPayData(orderNumber);
        }
    }

    @Override
    public void getWxMakeOrderData(MakeOrderBean productListBean) {
        if (productListBean.getData().getOrderNumber() != null) {
            presenter.sendGetWxPayData(productListBean.getData().getOrderNumber());
        }
    }

    @Override
    public void showGetPayData(GetPayDataBean getPayDataBean) {
        if (getPayDataBean.getData().getOrderSign() != null) {
//            AliPay(getPayDataBean.getData().getOrderSign());
//            支付宝支付
            PayUtils.getInstance().authV2(getPayDataBean.getData().getOrderSign(),this);
            PayUtils.getInstance().AliPay(getPayDataBean.getData().getOrderSign(),this);
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showGetWxPayData(PayWeChatBean payWeChatBean) {
        if (payWeChatBean.getData().getOrderSign() != null) {
//            WeChatPay(payWeChatBean.getData().getOrderSign());
//            微信支付
            PayUtils.getInstance().WeChatPay(payWeChatBean.getData().getOrderSign());
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showProductList(int position, int amount) {
        qieziId = position;
        qieziMoney = amount;
    }
}
