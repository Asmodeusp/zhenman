package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhy.autolayout.AutoRelativeLayout;

public class ShoppingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView app_back;
    private TextView app_title;
    private TextView app_otherID;
    private RecyclerView shopping_listRecy;
    private RadioButton shopping_zhifubaoBtn;
    private RadioButton shopping_weixinBtn;
    private RadioGroup shopping_radioGroup;
    private AutoRelativeLayout shopping_pay;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_shopping;
    }


    @Override
    protected void loadDate() {

    }

    protected void init() {
        app_back = (ImageView) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        app_otherID = (TextView) findViewById(R.id.app_otherID);
        shopping_listRecy = (RecyclerView) findViewById(R.id.shopping_listRecy);
        shopping_zhifubaoBtn = (RadioButton) findViewById(R.id.shopping_zhifubaoBtn);
        shopping_weixinBtn = (RadioButton) findViewById(R.id.shopping_weixinBtn);
        shopping_radioGroup = (RadioGroup) findViewById(R.id.shopping_radioGroup);
        shopping_pay = (AutoRelativeLayout) findViewById(R.id.shopping_pay);
        app_title.setText("购买茄子籽");
        idListener();
    }

    private void idListener() {
        app_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
