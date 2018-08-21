package com.zhenman.asus.zhenman.view.login;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import com.umeng.commonsdk.UMConfigure;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.LoginContract;
import com.zhenman.asus.zhenman.presenter.LoginPresenterImp;
import com.zhenman.asus.zhenman.view.ContentActivity;
import com.zhenman.asus.zhenman.view.login.qqlogin.UMSharePlatform;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;


public class MainActivity extends BaseActivity<LoginPresenterImp> implements View.OnClickListener, LoginContract.LoginView {

    private TextView mFastLanding;
    private ImageView mCommonCloseImage;
    private EditText mPhoneNumber;
    private EditText mInputPassword;
    private Button mLoginbtn;
    private TextView mRegisterBtn;
    private TextView mForgetPasswordBtn;
    private ImageView mLoginWeiboImage;
    private ImageView mLoginWeixinImage;
    private ImageView mLoginQqImage;
    private CheckBox mLogin_password_hide;
//    private Tencent mTencent;
//    private IUiListener iUiListener;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        //查找ID
        mFastLanding = findViewById(R.id.Fast_landing);
        mCommonCloseImage = findViewById(R.id.common_closeImage);
        mPhoneNumber = findViewById(R.id.PhoneNumber);
        mInputPassword = findViewById(R.id.InputPassword);
        mLoginbtn = findViewById(R.id.loginbtn);
        mRegisterBtn = findViewById(R.id.RegisterBtn);
        mForgetPasswordBtn = findViewById(R.id.ForgetPasswordBtn);
        mLoginWeiboImage = findViewById(R.id.login_weiboImage);
        mLoginWeixinImage = findViewById(R.id.login_weixinImage);
        mLoginQqImage = findViewById(R.id.login_qqImage);
        mLogin_password_hide = findViewById(R.id.login_password_hide);
        //设置点击事件
        mFastLanding.setOnClickListener(this);
        mCommonCloseImage.setOnClickListener(this);
        mLoginbtn.setOnClickListener(this);
        mRegisterBtn.setOnClickListener(this);
        mForgetPasswordBtn.setOnClickListener(this);
        mLoginWeiboImage.setOnClickListener(this);
        mLoginWeixinImage.setOnClickListener(this);
        mLoginQqImage.setOnClickListener(this);
        mLogin_password_hide.setOnClickListener(this);

    }


    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.common_closeImage:
                startActivity(new Intent(this, ContentActivity.class));
                break;
            case R.id.loginbtn:
                //手机号正则判断
                String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
                // "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
                if (!mPhoneNumber.getText().toString().trim().matches(telRegex)) {
                    Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
                }
                //密码正则判断


                presenter.getLogin(mPhoneNumber.getText().toString().trim(), mInputPassword.getText().toString().trim());
                break;
            case R.id.RegisterBtn:
                startActivity(new Intent(this, RegisterCodeActivity.class));
                break;
            case R.id.ForgetPasswordBtn:
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                break;
            case R.id.login_weiboImage:
//微博登陆

                break;
            case R.id.login_weixinImage:
//微信登陆

                UMShareAPI.get(this).getPlatformInfo(MainActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);

//                UMSharePlatform.loginThirdParty(this, SHARE_MEDIA.WEIXIN, new UMSharePlatform.LoginSuccessCallback() {
//                    @Override
//                    public void getLoginData(String uid) {
////                        mLoginPresenter.thirdPartyLoad(uid, "1");
//                        Log.d("Sunny", uid);
//                    }
//                });
                break;
            case R.id.login_qqImage:
//                调起QQ登录

//                UMSharePlatform.loginThirdParty(this, SHARE_MEDIA.QQ, new UMSharePlatform.LoginSuccessCallback() {
//                    @Override
//                    public void getLoginData(String uid) {
////                        mLoginPresenter.thirdPartyLoad(uid, "2");
//                    }
//                });


                break;
            case R.id.login_password_hide:
                if (mLogin_password_hide.isChecked()) {
                    mLogin_password_hide.setButtonDrawable(R.mipmap.login_password_show);
                    mInputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    mLogin_password_hide.setButtonDrawable(R.mipmap.login_password_hide);
                    mInputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;

        }

    }


    @Override
    public void gotoContent() {
        startActivity(new Intent(MainActivity.this, ContentActivity.class));
    }

    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    //    其中umAuthListener为授权回调，构建如下：
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }


        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(MainActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
