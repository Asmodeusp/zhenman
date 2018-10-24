package com.zhenman.asus.zhenman.view.myself;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SellEggplantContract;
import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;
import com.zhenman.asus.zhenman.presenter.SellEggplantPresenter;
import com.zhy.autolayout.AutoRelativeLayout;

import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class SellEggplantActivity extends BaseActivity<SellEggplantPresenter> implements SellEggplantContract.SellEggplantInView {


    @BindView(R.id.app_back)
    AutoRelativeLayout appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.app_otherID)
    TextView appOtherID;
    @BindView(R.id.sellEggplant_eggplantNum)
    TextView sellEggplantEggplantNum;
    @BindView(R.id.sellEggplant_money)
    TextView sellEggplantMoney;
    @BindView(R.id.sellEggplant_question)
    ImageView sellEggplantQuestion;
    @BindView(R.id.sellEggplant_sellBtn)
    Button sellEggplantSellBtn;
    @BindView(R.id.sellEggplant_footView)
    AutoRelativeLayout sellEggplantFootView;
    private static double eggplantMoney = 0;
    private static int eggplantAmount;
    @BindView(R.id.sellEggplant_img01)
    CircleImageView sellEggplantImg01;
    @BindView(R.id.sellEggplant_num01)
    TextView sellEggplantNum01;
    @BindView(R.id.sellEggplant_kind01)
    TextView sellEggplantKind01;
    @BindView(R.id.sellEggplant_isSelect01)
    CheckBox sellEggplantIsSelect01;
    @BindView(R.id.sellEggplant_img02)
    CircleImageView sellEggplantImg02;
    @BindView(R.id.sellEggplant_num02)
    TextView sellEggplantNum02;
    @BindView(R.id.sellEggplant_kind02)
    TextView sellEggplantKind02;
    @BindView(R.id.sellEggplant_isSelect02)
    CheckBox sellEggplantIsSelect02;
    @BindView(R.id.sellEggplant_item02)
    AutoRelativeLayout sellEggplantItem02;
    @BindView(R.id.sellEggplant_img03)
    CircleImageView sellEggplantImg03;
    @BindView(R.id.sellEggplant_num03)
    TextView sellEggplantNum03;
    @BindView(R.id.sellEggplant_kind03)
    TextView sellEggplantKind03;
    @BindView(R.id.sellEggplant_isSelect03)
    CheckBox sellEggplantIsSelect03;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sell_eggplant;
    }

    @Override
    protected void init() {
        appTitle.setText("卖茄子");
        appOtherID.setVisibility(View.VISIBLE);
        appOtherID.setText("茄子明细");
        //卖茄子
        presenter.sendSellEggplant();
       /* AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "app_id", "your private_key", "json", "GBK", "alipay_public_key", "RSA2");
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        Map map = new HashMap();
        map.put("out_biz_no", "3142321423432");
        map.put("payee_type", "ALIPAY_LOGONID");
        map.put("payee_account", "abc@sina.com");
        map.put("amount", "12.23");
        map.put("payer_show_name", "茄子提现");
        map.put("payee_real_name", "Sunny");
        map.put("remark", "真漫提现");
        //org.json.JSONObject 将Map转换为JSON方法
        JSONObject json = new JSONObject(map);
        request.setBizContent(json);
        AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }*/
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.app_back, R.id.app_otherID, R.id.sellEggplant_question, R.id.sellEggplant_sellBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_back:
                finish();
                break;
            case R.id.app_otherID:
                break;
            case R.id.sellEggplant_question:
                break;
            case R.id.sellEggplant_sellBtn:
                break;
        }
    }


    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSellEggplant(final SellEggplantBean eggplantDetailsBean) {
        sellEggplantImg01.setImageResource(R.mipmap.my_qiezi_small);
        sellEggplantImg02.setImageResource(R.mipmap.my_qiezi_bite);
        sellEggplantImg03.setImageResource(R.mipmap.my_qiezi_green);
        sellEggplantKind01.setText("茄子：" + eggplantDetailsBean.getData().getEggplantAmount());
        sellEggplantKind02.setText("被咬一口的茄子：" + eggplantDetailsBean.getData().getBiteEggplantAmount());
        sellEggplantKind03.setText("未成熟的茄子：" + eggplantDetailsBean.getData().getUnripeEggplantAmount());
        sellEggplantIsSelect01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sellEggplantIsSelect01.isChecked()) {
                    sellEggplantCallback(1, eggplantDetailsBean.getData().getEggplantAmount());

                } else {
                    sellEggplantNoSelectCallback(1, eggplantDetailsBean.getData().getEggplantAmount());
                }
            }
        });
        sellEggplantIsSelect02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sellEggplantIsSelect02.isChecked()) {
                    sellEggplantCallback(2, eggplantDetailsBean.getData().getBiteEggplantAmount());

                } else {
                    sellEggplantNoSelectCallback(2, eggplantDetailsBean.getData().getBiteEggplantAmount());
                }
            }
        });
        sellEggplantIsSelect03.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sellEggplantIsSelect03.isChecked()) {
                    sellEggplantCallback(3, eggplantDetailsBean.getData().getUnripeEggplantAmount());

                } else {
                    sellEggplantNoSelectCallback(3, eggplantDetailsBean.getData().getUnripeEggplantAmount());
                }
            }
        });
    }

    //  回调
    public void sellEggplantCallback(int type, int amount) {
        sellEggplantFootView.setVisibility(View.VISIBLE);
        eggplantAmount += amount;
        sellEggplantEggplantNum.setText(eggplantAmount + "");
        double v;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        if (type == 1) {
            v = 0.9;
            double v1 = amount * v;
            eggplantMoney += v1;
            String format = nf.format(eggplantMoney);
            sellEggplantMoney.setText(format);
        }
        if (type == 2) {
            v = 0.6;
            double v1 = amount * v;
            eggplantMoney += v1;
            String format = nf.format(eggplantMoney);
            sellEggplantMoney.setText(format);
        }
        if (type == 3) {
            v = 0.05;
            double v1 = amount * v;
            eggplantMoney += v1;
            String format = nf.format(eggplantMoney);
            sellEggplantMoney.setText(format);
        }

    }

    //取消选中
    public void sellEggplantNoSelectCallback(int type, int amount) {
        eggplantAmount -= amount;
        sellEggplantEggplantNum.setText(eggplantAmount + "");
        double v;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        if (eggplantAmount >= 0) {
            if (type == 1) {
                v = 0.9;
                double v1 = amount * v;
                eggplantMoney -= v1;
                String format = nf.format(eggplantMoney);
                sellEggplantMoney.setText(format);
            }
            if (type == 2) {
                v = 0.6;
                double v1 = amount * v;
                eggplantMoney -= v1;
                String format = nf.format(eggplantMoney);
                sellEggplantMoney.setText(format);
            }
            if (type == 3) {
                v = 0.05;
                double v1 = amount * v;
                eggplantMoney -= v1;
                String format = nf.format(eggplantMoney);
                sellEggplantMoney.setText(format);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}