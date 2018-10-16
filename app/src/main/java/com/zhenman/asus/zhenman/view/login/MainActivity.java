package com.zhenman.asus.zhenman.view.login;


import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.LoginContract;
import com.zhenman.asus.zhenman.model.bean.ThirdPartyLoginBean;
import com.zhenman.asus.zhenman.model.bean.UserBean;
import com.zhenman.asus.zhenman.presenter.LoginPresenterImp;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.utils.umeng.ShareCallBack;
import com.zhenman.asus.zhenman.utils.umeng.UMengHelp;
import com.zhenman.asus.zhenman.view.ContentActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.Map;


public class MainActivity extends BaseActivity<LoginPresenterImp> implements View.OnClickListener, LoginContract.LoginView{

    private TextView mFastLanding;
    private AutoRelativeLayout mCommonCloseImage;
    private EditText mPhoneNumber;
    private EditText mInputPassword;
    private Button mLoginbtn;
    private TextView mRegisterBtn;
    private TextView mForgetPasswordBtn;
    private ImageView mLoginWeiboImage;
    private ImageView mLoginWeixinImage;
    private ImageView mLoginQqImage;
    private CheckBox mLogin_password_hide;
    //QQ分享的请求码
    public static final int SHARE_QQ_REQUEST_CODE = 1;
    //QQ分享不带面板的请求码
    public static final int SHARE_QQ_UN_REQUEST_CODE = 2;
    //微信分享的请求码
    public static final int SHARE_WE_CAT_REQUEST_CODE = 3;
    //微信分享不带面板的请求码
    public static final int SHARE_WE_CAT_UN_REQUEST_CODE = 4;
    //微博分享的请求码
    public static final int SHARE_SINA_REQUEST_CODE = 5;
    //微博分享不带面板的请求码
    public static final int SHARE_SINA_UN_REQUEST_CODE = 6;
    //qq登录
    public static final int QQ_LOGIN = 7;
    //微信登录
    public static final int WE_CAT_LOGIN = 8;
    //微博登录
    public static final int SINA_LOGIN = 9;
    private String umeng_type;
    private String uMeng_otheruserId;
    private String uMeng_openid;
    private String uMeng_headimage;
    private String uMeng_name;
    private String uMeng_cityname;
    private String uMeng_sex;
    private String loginType;
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         //         * @desc 授权开始的回调
         //         * @param platform 平台名称
         //         */
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
            //                type值判断是哪个第三方登录的   微信 1 新浪2 QQ 3
            if (platform.equals(SHARE_MEDIA.WEIXIN)) {
                TYPE = "1";
            } else if (platform.equals(SHARE_MEDIA.SINA)) {
                TYPE = "2";
            } else if (platform.equals(SHARE_MEDIA.QQ)) {
                TYPE = "3";
            }

            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
            String gender = data.get("gender");
            String sex = "";
            if ("女".equals(gender)) {
//                    男1 女2
                sex = "2";
                SPUtils.put(MainActivity.this, SPKey.UMeng_SEX, "2");
            } else {
                sex = "1";
                SPUtils.put(MainActivity.this, SPKey.UMeng_SEX, "1");
            }
            if (TYPE.equals("2")) {//微博

                String description = data.get("description");
                String avatarHd = data.get("avatar_hd");
                String otherUserId = data.get("avatargj_id");
                String openId = data.get("uid");
                SPUtils.put(MainActivity.this, SPKey.UMeng_OTHERUSERId, otherUserId + "");
                presenter.sendUMengLoginData(otherUserId, data.get("name"), data.get("location"),
                        avatarHd, sex, TYPE, openId);

            }
            if (TYPE.equals("1")) {//微信
                SPUtils.put(MainActivity.this, SPKey.UMeng_OTHERUSERId, data.get("unionid"));
                presenter.sendUMengLoginData(data.get("unionid"), data.get("name"), "",
                        data.get("iconurl"), sex, TYPE, data.get("openid"));
//                Log.e("Sunny",data.get("unionid"));
//                Log.e("Sunny",data.get("openid"));

            }
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
    private EditText PhoneNumber;
    private EditText InputPassword;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        getDatafromSP();
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
        //设置EditText文本框输入监听事件
        mPhoneNumber.addTextChangedListener(textWatcher);
        mInputPassword.addTextChangedListener(textWatcher);
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

    //    给定登陆方式
    private static String TYPE;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_closeImage:
//                跳转到首页
                startActivity(new Intent(this, ContentActivity.class));
                finish();
                break;
            case R.id.loginbtn:
                if (mPhoneNumber.getText().toString().isEmpty() || mInputPassword.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请检查您的手机号或密码是否输入", Toast.LENGTH_SHORT).show();
                } else {
                    //手机号正则判断
                    String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
                    // "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
                    if (!mPhoneNumber.getText().toString().trim().matches(telRegex)) {
                        Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
                    }
                    //密码正则判断
                    presenter.getLogin(mPhoneNumber.getText().toString().trim(), mInputPassword.getText().toString().trim());
                    SPUtils.put(this, SPKey.USER_MOBILE, mPhoneNumber.getText().toString());
                }

                break;
            case R.id.RegisterBtn:
                Intent intent = new Intent(this, RegisterCodeActivity.class);
                intent.putExtra("bind", "注册");
                startActivity(intent);
                break;
            case R.id.ForgetPasswordBtn:
                String userName = (String) SPUtils.get(this, SPKey.UMeng_NAME, "");
                if (userName.isEmpty()) {
                    Toast.makeText(this, "请先完成登陆", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, ForgetPasswordActivity.class));
                }
                break;
            case R.id.login_weiboImage:
                //微博登录
                UMengHelp.applySharePermission(this, SINA_LOGIN, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.login(MainActivity.this, SHARE_MEDIA.SINA, umAuthListener);
                    }
                });
                break;
            case R.id.login_weixinImage:
                //微信登录
                UMengHelp.applySharePermission(this, WE_CAT_LOGIN, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.login(MainActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
                    }
                });
                break;
            case R.id.login_qqImage:
                //qq登录
                UMengHelp.applySharePermission(this, QQ_LOGIN, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.login(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                    }
                });

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

    //    从SP中取到数据
    private void getDatafromSP() {
        Boolean is_login = (Boolean) SPUtils.get(this, SPKey.IS_LOGIN, false);
//       判断是否登陆，如果登陆过就直接进入首页
        if (is_login) {
            startActivity(new Intent(this, ContentActivity.class));
        } else {
            Toast.makeText(this, "请登陆", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void gotoContent(UserBean userBean) {

        //如果登陆成功就利用SP储存用户信息
        if (userBean.getData().getToken()!=null){
            SPUtils.put(App.context, SPKey.USER_TOKEN, userBean.getData().getToken());

        }if (userBean.getData().getRefreshToken()!=null){
            SPUtils.put(App.context, SPKey.USER_REFRESHTOKEN, userBean.getData().getRefreshToken());

        }
        if ((String)userBean.getData().getSex()!=null) {
            SPUtils.put(App.context, SPKey.USER_SEX, userBean.getData().getSex() + "");
        }else {
            SPUtils.put(App.context, SPKey.USER_SEX, 1 + "");

        }
        SPUtils.put(App.context, SPKey.UMeng_NAME, userBean.getData().getName());

        if (userBean.getData().getIntroduction() != null) {
            SPUtils.put(App.context, SPKey.USER_INTRODUCTION, userBean.getData().getIntroduction());
        }else {
            SPUtils.put(App.context, SPKey.USER_INTRODUCTION,"本宝宝暂时没有介绍呢~");

        }
        SPUtils.put(App.context, SPKey.USER_ID, userBean.getData().getId()+"");
//                            保存登陆成功
        SPUtils.put(App.context, SPKey.IS_LOGIN, true);
        startActivity(new Intent(MainActivity.this, ContentActivity.class));
        finish();
    }
    //    得到友盟返回的数据
    @Override
    public void showUMengLoginData(ThirdPartyLoginBean uMengLoginBean) {
        if (!uMengLoginBean.getMsg().isEmpty() && uMengLoginBean.getMsg().equals("成功")) {
//                成功的话保存到sp中
            SPUtils.put(MainActivity.this, SPKey.UMeng_CITYNAME, uMengLoginBean.getData().getCityName());
            SPUtils.put(MainActivity.this, SPKey.UMeng_NAME, uMengLoginBean.getData().getName());
            if (uMengLoginBean.getData().getMobile() != null) {
                SPUtils.put(MainActivity.this, SPKey.USER_MOBILE, uMengLoginBean.getData().getMobile());
            }
            SPUtils.put(MainActivity.this, SPKey.USER_ID, uMengLoginBean.getData().getId());
            if (uMengLoginBean.getData().getIntroduction() != null) {
                SPUtils.put(MainActivity.this, SPKey.USER_INTRODUCTION, uMengLoginBean.getData().getIntroduction());
            }
            SPUtils.put(MainActivity.this, SPKey.USER_REFRESHTOKEN, uMengLoginBean.getData().getRefreshToken());

            SPUtils.put(MainActivity.this, SPKey.USER_OAUTHID, uMengLoginBean.getData().getOauthId());
            if (uMengLoginBean.getData().getBirthdate() != null) {
                SPUtils.put(MainActivity.this, SPKey.USER_BIRTHDAY, uMengLoginBean.getData().getBirthdate());
            }
            if (uMengLoginBean.getData().getQqName() != null) {
                SPUtils.put(MainActivity.this, SPKey.QQ_NAME, uMengLoginBean.getData().getQqName());
            }
            if (uMengLoginBean.getData().getWeiboName() != null) {
                SPUtils.put(MainActivity.this, SPKey.SINA_NAME, uMengLoginBean.getData().getWeiboName());
            }
            if (uMengLoginBean.getData().getWeixinName() != null) {
                SPUtils.put(MainActivity.this, SPKey.WEIXIN_NAME, uMengLoginBean.getData().getWeixinName());
            }
            SPUtils.put(MainActivity.this, SPKey.USER_SEX, uMengLoginBean.getData().getSex());
            SPUtils.put(MainActivity.this, SPKey.USER_TOKEN, uMengLoginBean.getData().getToken());
            SPUtils.put(MainActivity.this, SPKey.IS_LOGIN, (Boolean) true);
            SPUtils.put(MainActivity.this, SPKey.USER_AVATAR, uMengLoginBean.getData().getHeadImg());
            SPUtils.put(MainActivity.this, SPKey.LOGIN_TYPE, TYPE);
            startActivity(new Intent(MainActivity.this, ContentActivity.class));
        } else {
            Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(String msg) {
        if (!msg.equals("成功")) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 分享权限的回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case SHARE_QQ_REQUEST_CODE:
                UMengHelp.responseSharePermission(this, grantResults, SHARE_QQ_REQUEST_CODE, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.shareWeb(MainActivity.this, "https://www.asda.com/", "分享的链接", "2432423423",
                                "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1782685035,253150800&fm=27&gp=0.jpg", R.mipmap.guanzhu_like_off, SHARE_MEDIA.QZONE, true);
                    }
                });
                break;
            case SHARE_QQ_UN_REQUEST_CODE:
                UMengHelp.responseSharePermission(this, grantResults, SHARE_QQ_UN_REQUEST_CODE, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.shareWeb(MainActivity.this, "https://www.asda.com/", "分享的链接", "2432423423",
                                "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1782685035,253150800&fm=27&gp=0.jpg", R.mipmap.guanzhu_like_off, SHARE_MEDIA.QZONE, true);
                    }
                });
                break;
            case SHARE_WE_CAT_REQUEST_CODE:
                UMengHelp.responseSharePermission(this, grantResults, SHARE_WE_CAT_REQUEST_CODE, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.shareText(MainActivity.this, SHARE_MEDIA.WEIXIN, "分享纯文本到微信", true);
                    }
                });
                break;
            case SHARE_WE_CAT_UN_REQUEST_CODE:
                UMengHelp.responseSharePermission(this, grantResults, SHARE_WE_CAT_UN_REQUEST_CODE, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.shareText(MainActivity.this, SHARE_MEDIA.WEIXIN, "分享纯文本到微信", false);
                    }
                });
                break;
            case SHARE_SINA_REQUEST_CODE:
                UMengHelp.responseSharePermission(this, grantResults, SHARE_SINA_REQUEST_CODE, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.shareText(MainActivity.this, SHARE_MEDIA.SINA, "分享纯文本", true);
                    }
                });
                break;
            case SHARE_SINA_UN_REQUEST_CODE:
                UMengHelp.responseSharePermission(this, grantResults, SHARE_SINA_UN_REQUEST_CODE, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.shareText(MainActivity.this, SHARE_MEDIA.SINA, "分享纯文本", false);
                    }
                });
                break;
            case QQ_LOGIN:
                UMengHelp.responseSharePermission(this, grantResults, QQ_LOGIN, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.login(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                    }
                });
                break;
            case WE_CAT_LOGIN:
                UMengHelp.responseSharePermission(this, grantResults, WE_CAT_LOGIN, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.login(MainActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
                    }
                });
                break;
            case SINA_LOGIN:
                UMengHelp.responseSharePermission(this, grantResults, SINA_LOGIN, new ShareCallBack() {
                    @Override
                    public void shareOrLogin() {
                        UMengHelp.login(MainActivity.this, SHARE_MEDIA.SINA, umAuthListener);
                    }
                });
                break;
        }
    }

    //    新浪和QQ需要加
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Boolean is_login = (Boolean) SPUtils.get(this, SPKey.IS_LOGIN, false);
//       判断是否登陆，如果登陆过就直接进入首页
        if (is_login) {
            finish();
        } else {
            Toast.makeText(this, "请登陆", Toast.LENGTH_SHORT).show();
        }
    }

//输入框的监听
        TextWatcher textWatcher = new TextWatcher() {
            // 输入文本之前的状态
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            // 输入文本中的状态
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            // 输入文本之后的状态
            @Override
            public void afterTextChanged(Editable s) {
                if (mPhoneNumber.getText().toString().isEmpty() || mInputPassword.getText().toString().isEmpty()) {
                    mLoginbtn.setAlpha(0.5f);
                } else {
                    mLoginbtn.setAlpha(1.0f);
                }
            }
        };
    }

