package com.zhenman.asus.zhenman.view.myself;

import android.content.Intent;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.model.bean.EggplantDetailsBean;
import com.zhy.autolayout.AutoRelativeLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

public class SaleDetailsActivity extends BaseActivity {


    @BindView(R.id.app_back)
    AutoRelativeLayout appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.saleDetails_qieziNum)
    TextView saleDetailsQieziNum;
    @BindView(R.id.saleDetails_biteQieziNum)
    TextView saleDetailsBiteQieziNum;
    @BindView(R.id.saleDetails_unripeQieziNum)
    TextView saleDetailsUnripeQieziNum;
    @BindView(R.id.saleDetails_aboveQieziNum)
    TextView saleDetailsAboveQieziNum;
    @BindView(R.id.saleDetails_aboveQieziMoney)
    TextView saleDetailsAboveQieziMoney;
    @BindView(R.id.saleDetails_data)
    TextView saleDetailsData;
    @BindView(R.id.saleDetails_sellTo)
    TextView saleDetailsSellTo;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_sale_details;
    }

    @Override
    protected void init() {
        appTitle.setText("出售详情");
        Intent intent = getIntent();
        List<EggplantDetailsBean.DataBean.DetailDtoBean> saleData = (List<EggplantDetailsBean.DataBean.DetailDtoBean>) intent.getSerializableExtra("saleData");
        for (int i = 0; i < saleData.size(); i++) {
            saleDetailsQieziNum.setText(saleData.get(i).getEggplantAmount());
            saleDetailsBiteQieziNum.setText(saleData.get(i).getBiteEggplantAmount());
            saleDetailsUnripeQieziNum.setText(saleData.get(i).getUnripeEggplantAmount());
            saleDetailsAboveQieziNum.setText(saleData.get(i).getTotal()+"");
            saleDetailsAboveQieziMoney.setText(saleData.get(i).getAmount()+"");
            //            时间转换
            Date date = new Date(Long.parseLong(saleData.get(i).getAddTime()));
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd hh:mm", Locale.getDefault());
            String format2 = format.format(date);
            saleDetailsData.setText(format2);
            if (saleData.get(i).getSellTo()==1){//sellTo字段为1的话是卖向微信
                saleDetailsSellTo.setText("元，卖向微信。");
            }else if (saleData.get(i).getSellTo()==2){//sellTo字段为2的时候是卖向支付宝
                saleDetailsSellTo.setText("元，卖向支付宝。");

            }
        }
    }

    @Override
    protected void loadDate() {

    }


    @OnClick(R.id.app_back)
    public void onViewClicked() {
        finish();
    }


}
