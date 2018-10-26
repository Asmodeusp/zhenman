package com.zhenman.asus.zhenman.view.myself;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.MyWalletContract;
import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;
import com.zhenman.asus.zhenman.presenter.MyWalletPresenter;
import com.zhy.autolayout.AutoRelativeLayout;

public class MyWalletActivity extends BaseActivity<MyWalletPresenter> implements View.OnClickListener, MyWalletContract.SellEggplantInView {

    private AutoRelativeLayout app_back;
    private TextView app_title;
    private TextView myWallet_num;
    private TextView myWallet_question;
    private RelativeLayout myWallet_shop;
    private AutoRelativeLayout myWallet_history;
    private AutoRelativeLayout myWallet_sell;
    private SellEggplantBean.DataBean eggplantDetsBeanData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_wallet;
    }

    @Override
    protected void init() {
        app_back = (AutoRelativeLayout) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        myWallet_num = (TextView) findViewById(R.id.myWallet_num);
        myWallet_shop = (RelativeLayout) findViewById(R.id.myWallet_shop);
        myWallet_history = (AutoRelativeLayout) findViewById(R.id.myWallet_history);
        myWallet_sell = (AutoRelativeLayout) findViewById(R.id.myWallet_sell);
        myWallet_question = (TextView) findViewById(R.id.myWallet_question);
        app_title.setText("我的");
//        茄子籽数量
        presenter.sendSellEggplant();
        idListener();
    }

    private void idListener() {
        app_back.setOnClickListener(this);
        myWallet_shop.setOnClickListener(this);
        myWallet_history.setOnClickListener(this);
        myWallet_sell.setOnClickListener(this);
        myWallet_question.setOnClickListener(this);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_back:
                finish();
                break;
            case R.id.myWallet_shop:
                startActivity(new Intent(MyWalletActivity.this, BuyEggplantActivity.class));
                break;
            case R.id.myWallet_history:
                startActivity(new Intent(MyWalletActivity.this, PurchaseHistoryActivity.class));
                break;
            case R.id.myWallet_sell:
                Intent intent = new Intent(MyWalletActivity.this, SellEggplantActivity.class);
                startActivity(intent);
                break;
            case R.id.myWallet_question:

                break;

        }
    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showSellEggplant(SellEggplantBean eggplantDetsBean) {
        eggplantDetsBeanData = eggplantDetsBean.getData();
        myWallet_num.setText(" X " + eggplantDetsBeanData.getCoinAmount() + "");
    }
}
