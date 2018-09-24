package com.zhenman.asus.zhenman.view.login;


import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SetPasswordContract;
import com.zhenman.asus.zhenman.presenter.SetPasswordPresenterImp;

public class SetPasswordActivity extends BaseActivity<SetPasswordPresenterImp> implements View.OnClickListener,SetPasswordContract.SetPassWordView {

    private ImageView mSetPasswordReturn;
    private EditText mSetPasswordInputPasswordEd;
    private CheckBox mSetPasswordHide;
    private EditText mSetPasswordReSetInputPasswordEd;
    private CheckBox mReSetPasswordHide;
    private Button mSetPasswordNextBtn;
    private String msmcode;
    private String phone;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_password;
    }

    @Override
    protected void init() {
        initView();
        Intent intent = getIntent();
        msmcode = intent.getStringExtra("smsCode");
        phone = intent.getStringExtra("phone");


    }

    @Override
    protected void loadDate() {

    }

    private void initView() {
        //查找ID
        //返回
        mSetPasswordReturn = (ImageView) findViewById(R.id.SetPassword_return);
        mSetPasswordInputPasswordEd = (EditText) findViewById(R.id.SetPasswordInputPassword_Ed);
        mSetPasswordHide = (CheckBox) findViewById(R.id.SetPassword_hide);
        mSetPasswordReSetInputPasswordEd = (EditText) findViewById(R.id.SetPasswordReSetInputPassword_Ed);
        mReSetPasswordHide = (CheckBox) findViewById(R.id.ReSet_password_hide);
        mSetPasswordNextBtn = (Button) findViewById(R.id.SetPassword_NextBtn);
        //设置点击事件
        mSetPasswordReturn.setOnClickListener(this);
        mSetPasswordHide.setOnClickListener(this);
        mReSetPasswordHide.setOnClickListener(this);
        mSetPasswordNextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //完成按钮
            case R.id.SetPassword_NextBtn:
                if (mSetPasswordInputPasswordEd.getText().toString().trim().equals(mSetPasswordReSetInputPasswordEd.getText().toString().trim())) {
                    Toast.makeText(this, "两次输入不一致", Toast.LENGTH_SHORT).show();
                }else{
                    presenter.getRegisterLoginCode(phone,msmcode,mSetPasswordInputPasswordEd.getText().toString().trim());
                }
                break;
            //设置密码是否可见按钮
            case R.id.SetPassword_hide:
                if (mSetPasswordHide.isChecked()) {
                    mSetPasswordHide.setButtonDrawable(R.mipmap.login_password_show);
                    mSetPasswordInputPasswordEd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    mSetPasswordHide.setButtonDrawable(R.mipmap.login_password_hide);
                    mSetPasswordInputPasswordEd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            //重新输入密码是否可见按钮
            case R.id.ReSet_password_hide:
                if (mReSetPasswordHide.isChecked()) {
                    mReSetPasswordHide.setButtonDrawable(R.mipmap.login_password_show);
                    mSetPasswordReSetInputPasswordEd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    mReSetPasswordHide.setButtonDrawable(R.mipmap.login_password_hide);
                    mSetPasswordReSetInputPasswordEd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            //返回按钮
            case R.id.SetPassword_return:
                finish();
                break;
        }
    }

    @Override
    public void gotoSetUserInfo() {
            startActivity(new Intent(this,UserInfoActivity.class));
            finish();
    }

    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
