package com.zhenman.asus.zhenman.view.myself;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.AccountManageContract;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.presenter.AccountManagePresenter;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.utils.umeng.ShareCallBack;
import com.zhenman.asus.zhenman.utils.umeng.UMengHelp;
import com.zhenman.asus.zhenman.view.login.BindPhotoActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.Map;

public class AccountManagementActivity extends BaseActivity<AccountManagePresenter> implements View.OnClickListener, AccountManageContract.AccountManageInView {


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
    private String user_mobile;
    private String sina_name;
    private String weixin_name;
    private String qq_name;
    private Intent intentPhone;
    //qq登录
    public static final int QQ_LOGIN = 7;
    //微信登录
    public static final int WE_CAT_LOGIN = 8;
    //微博登录
    public static final int SINA_LOGIN = 9;
    private String TYPE;
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

            Toast.makeText(AccountManagementActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
            String gender = data.get("gender");
            String sex = "";
            if ("女".equals(gender)) {
//                    男1 女2
                sex = "2";
                SPUtils.put(AccountManagementActivity.this, SPKey.UMeng_SEX, "2");
            } else {
                sex = "1";
                SPUtils.put(AccountManagementActivity.this, SPKey.UMeng_SEX, "1");
            }
            SPUtils.put(AccountManagementActivity.this, SPKey.UMeng_OTHERUSERId, data.get("unionid"));
            Log.e("Sunny", data.get("unionid"));
            Log.e("Sunny", data.get("openid"));
            Log.e("Sunny", TYPE);

            if (user_mobile.isEmpty()) {
//               如果手机号为空就代表是第三方绑定第三方
                presenter.sendThirdBindThirdData((String) SPUtils.get(AccountManagementActivity.this, SPKey.USER_OAUTHID, "")
                        , data.get("unionid")
                        , TYPE
                        , (String) SPUtils.get(AccountManagementActivity.this, SPKey.UMeng_NAME, ""));
            } else {
//                手机号绑定第三方
                presenter.sendPhoneBindThirdData(user_mobile, data.get("unionid"), TYPE, (String) SPUtils.get(AccountManagementActivity.this, SPKey.UMeng_NAME, ""), "",
                        data.get("iconurl"), sex, data.get("openid"));
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
            Toast.makeText(AccountManagementActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(AccountManagementActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

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
        setData();
        idListener();

    }

    //    从SP中获取用户信息设置
    private void setData() {
        user_mobile = (String) SPUtils.get(this, SPKey.USER_MOBILE, "");
        sina_name = (String) SPUtils.get(this, SPKey.SINA_NAME, "");
        weixin_name = (String) SPUtils.get(this, SPKey.WEIXIN_NAME, "");
        qq_name = (String) SPUtils.get(this, SPKey.QQ_NAME, "");
        if (!user_mobile.isEmpty()) {
            account_Tel.setText(user_mobile);
        } else {
            account_Tel.setText("未绑定");
        }
        if (!sina_name.isEmpty()) {
            account_sina.setText(sina_name);
        } else {
            account_sina.setText("未绑定");
        }
        if (!weixin_name.isEmpty()) {
            account_weixin.setText(weixin_name);
        } else {
            account_weixin.setText("未绑定");
        }
        if (!qq_name.isEmpty()) {
            account_qq.setText(qq_name);
        } else {
            account_qq.setText("未绑定");
        }
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
                intentPhone = new Intent(AccountManagementActivity.this, BindPhotoActivity.class);
                if (user_mobile.isEmpty()) {
                    intentPhone.putExtra("bind", "未绑定手机号");
                    startActivity(intentPhone);
                } else {
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("您要进行的操作是？")
                            .setNegativeButton("更换绑定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //                    如果之前又手机号登陆，就绑定新的手机号
                                    intentPhone.putExtra("bind", "已有手机号，更换绑定");
                                    startActivity(intentPhone);
                                }
                            })
                            .setPositiveButton("解除绑定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();


                }

                break;
            case R.id.account_bindWeixin:
                if (weixin_name.isEmpty()) {
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("去绑定微信？")
                            .setNegativeButton("取消", null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                } else {
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("是否解除微信绑定？")
                            .setNegativeButton("取消", null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                }
                break;
            case R.id.account_bindQQ:
                if (qq_name.isEmpty()) {
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("去绑定QQ？")
                            .setNegativeButton("取消", null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                } else {
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("是否解除QQ绑定？")
                            .setNegativeButton("取消", null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                }
                break;
            case R.id.account_bindSina:
                if (sina_name.isEmpty()) {
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("去绑定微博？")
                            .setNegativeButton("取消", null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //微博登录
                                    UMengHelp.applySharePermission(AccountManagementActivity.this, SINA_LOGIN, new ShareCallBack() {
                                        @Override
                                        public void shareOrLogin() {
                                            UMengHelp.login(AccountManagementActivity.this, SHARE_MEDIA.SINA, umAuthListener);
                                        }
                                    });
                                }
                            })
                            .show();
                } else {
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("是否解除微博绑定？")
                            .setNegativeButton("取消", null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setData();
    }

    //    手机号绑定第三方
    @Override
    public void showPhoneBindThirdData(VerificationCodeBean verificationCodeBean) {
        if (verificationCodeBean.getState()==0) {
            Toast.makeText(this, "绑定成功", Toast.LENGTH_SHORT).show();
        }
    }

    //    第三方绑定第三方
    @Override
    public void showThirdBindThirdData(VerificationCodeBean verificationCodeBean) {

    }

    @Override
    public void showError(String string) {

    }
    //    新浪和QQ需要加
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
