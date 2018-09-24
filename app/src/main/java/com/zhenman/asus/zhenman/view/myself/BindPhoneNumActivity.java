package com.zhenman.asus.zhenman.view.myself;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.BindNewPhoneNumContract;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.presenter.BindNewPhoneNumPresenter;
import com.zhenman.asus.zhenman.utils.SmsCodeDownUtil;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

public class BindPhoneNumActivity extends BaseActivity<BindNewPhoneNumPresenter> implements View.OnClickListener, BindNewPhoneNumContract.BindNewPhoneNumInView {

    private ImageView alartBind_return;
    private TextView alartBind_text;
    private EditText alartBind_PhoneNumberEd;
    private EditText alartBind_PhoneCodeEd;
    private TextView alartBind_PhotoCodeText;
    private Button alartBind_NextBtn;
    private SmsCodeDownUtil smsCodeDownUtil;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_phone_num;
    }

    @Override
    protected void init() {
        alartBind_return = (ImageView) findViewById(R.id.alartBind_return);
        alartBind_text = (TextView) findViewById(R.id.alartBind_text);
        alartBind_PhoneNumberEd = (EditText) findViewById(R.id.alartBind_PhoneNumberEd);
        alartBind_PhoneCodeEd = (EditText) findViewById(R.id.alartBind_PhoneCodeEd);
        alartBind_PhotoCodeText = (TextView) findViewById(R.id.alartBind_PhotoCodeText);
        alartBind_NextBtn = (Button) findViewById(R.id.alartBind_NextBtn);
        alartBind_NextBtn.setOnClickListener(this);
        alartBind_PhotoCodeText.setOnClickListener(this);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alartBind_NextBtn:
                submit();
                break;
            case R.id.alartBind_PhotoCodeText:
                smsCodeDownUtil = new SmsCodeDownUtil(alartBind_PhotoCodeText, "%s", 60);
                smsCodeDownUtil.start();
                String countdownText = smsCodeDownUtil.getCountdownText();
                alartBind_PhotoCodeText.setText(countdownText);
                presenter.sendAlartPhoneNumData(alartBind_PhoneNumberEd.getText().toString().trim(), "1", "1234");
                break;
        }
    }

    private void submit() {
        // validate
        String PhoneNumberEd = alartBind_PhoneNumberEd.getText().toString().trim();
        if (TextUtils.isEmpty(PhoneNumberEd)) {
            Toast.makeText(this, "PhoneNumberEd不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String PhoneCodeEd = alartBind_PhoneCodeEd.getText().toString().trim();
        if (TextUtils.isEmpty(PhoneCodeEd)) {
            Toast.makeText(this, "PhoneCodeEd不能为空", Toast.LENGTH_SHORT).show();
            return;
        }//正则判断手机号
        String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        if (!PhoneNumberEd.trim().matches(REGEX_MOBILE)) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
        } else {
            presenter.sendBindNewPhoneNumData(PhoneNumberEd, PhoneCodeEd);
        }


        // TODO validate success, do something


    }

    //    绑定新的手机号
    @Override
    public void showBindNewPhoneNumData(VerificationCodeBean verificationCodeBean) {
        if (verificationCodeBean.getState() == 0) {
//            如果成功的话就把手机号保存到SP中
            SPUtils.put(this, SPKey.USER_MOBILE, alartBind_PhoneNumberEd.getText().toString());

            startActivity(new Intent(BindPhoneNumActivity.this, AccountManagementActivity.class));
        } else {
            Toast.makeText(this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    //展示错误数据
    @Override
    public void showError(String string) {

    }

    //    获取图片验证码
    @Override
    public void showAlartPhoneNumData(VerificationCodeBean verificationCodeBean) {
        if (verificationCodeBean.getState() == 0) {
//
        } else {
            Toast.makeText(this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }
}
