package com.zhenman.asus.zhenman.view.myself;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhy.autolayout.AutoRelativeLayout;

public class AccountManagementActivity extends BaseActivity implements View.OnClickListener {


    private ImageView account_back;
    private AutoRelativeLayout account_modifyPassword;
    private TextView account_Tel;
    private AutoRelativeLayout account_bindPhoneNum;
    private TextView account_weixin;
    private AutoRelativeLayout account_bindWeixin;
    private TextView account_qq;
    private AutoRelativeLayout account_bindQQ;
    private TextView account_sina;
    private AutoRelativeLayout account_bindSina;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_management;
    }

    @Override
    protected void init() {
        account_back = findViewById(R.id.account_Back);
        account_modifyPassword = findViewById(R.id.account_modifyPassword);
        account_Tel = findViewById(R.id.account_Tel);
        account_bindPhoneNum = findViewById(R.id.account_bindPhoneNum);
        account_weixin = findViewById(R.id.account_weixin);
        account_bindWeixin = findViewById(R.id.account_bindWeixin);
        account_qq = findViewById(R.id.account_qq);
        account_bindQQ = findViewById(R.id.account_bindQQ);
        account_sina = findViewById(R.id.account_sina);
        account_bindSina = findViewById(R.id.account_bindSina);
        idListener();
    }

    private void idListener() {
        account_back.setOnClickListener(this);
        account_modifyPassword.setOnClickListener(this);
        account_bindPhoneNum.setOnClickListener(this);
        account_bindWeixin.setOnClickListener(this);
        account_bindQQ.setOnClickListener(this);
        account_bindSina.setOnClickListener(this);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.account_Back:
                finish();
                break;
            case R.id.account_modifyPassword:
                startActivity(new Intent(this, ModifyPasswordOneActivity.class));
                break;
            case R.id.account_bindPhoneNum:
                break;
            case R.id.account_bindWeixin:
                break;
            case R.id.account_bindQQ:
                break;
            case R.id.account_bindSina:
                break;
        }
    }
}
