package com.zhenman.asus.zhenman.view.myself;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhy.autolayout.AutoRelativeLayout;

public class MyWalletActivity extends BaseActivity implements View.OnClickListener {

    private ImageView app_back;
    private TextView app_title;
    private TextView myWallet_num;
    private RelativeLayout myWallet_shop;
    private AutoRelativeLayout myWallet_history;
    private AutoRelativeLayout myWallet_sell;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_wallet;
    }

    @Override
    protected void init() {
        app_back = (ImageView) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        myWallet_num = (TextView) findViewById(R.id.myWallet_num);
        myWallet_shop = (RelativeLayout) findViewById(R.id.myWallet_shop);
        myWallet_history = (AutoRelativeLayout) findViewById(R.id.myWallet_history);
        myWallet_sell = (AutoRelativeLayout) findViewById(R.id.myWallet_sell);
        app_title.setText("我的钱包");
        idListener();
    }

    private void idListener() {
        app_back.setOnClickListener(this);
        myWallet_shop.setOnClickListener(this);
        myWallet_history.setOnClickListener(this);
        myWallet_sell.setOnClickListener(this);
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
                startActivity(new Intent(MyWalletActivity.this,ShoppingActivity.class));
                break;
            case R.id.myWallet_history:
                startActivity(new Intent(MyWalletActivity.this,PurchaseHistoryActivity.class));
                break;
            case R.id.myWallet_sell:

                break;
        }
    }
}
