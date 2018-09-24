package com.zhenman.asus.zhenman.view.login;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.AlartPhoneNumContract;
import com.zhenman.asus.zhenman.model.bean.VerificationCodeBean;
import com.zhenman.asus.zhenman.presenter.AlartPhoneNumPresenter;
import com.zhenman.asus.zhenman.utils.SmsCodeDownUtil;
import com.zhenman.asus.zhenman.utils.Urls;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.myself.BindPhoneNumActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BindPhotoActivity extends BaseActivity<AlartPhoneNumPresenter> implements View.OnClickListener, AlartPhoneNumContract.AlartPhoneNumInView {

    private ImageView mRegisterReturn;
    private EditText mRegisterPhoneNumber;
    private EditText mRegisterPhotoCodeEd;
    private TextView mRegisterPhotoCode;
    private Button mRegisterNextBtn;
    private LinearLayout mRegister_Code_Lin;
    private ImageView imageCode;
    private EditText image_code_ed;
    private LinearLayout image_code_reload_btn;
    private ImageView image_code_return;
    private TextView image_code_sure_btn;
    private TextView register_text;
    private EditText imageCode_ed;
    private PopupWindow window;
    private String isBind;
    private SmsCodeDownUtil smsCodeDownUtil;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register_code;
    }

    @Override
    protected void init() {
        //返回
        mRegisterReturn = findViewById(R.id.Register_return);
        //
        register_text = findViewById(R.id.register_text);
        //父容器
        mRegister_Code_Lin = findViewById(R.id.Register_Code_Lin);
        //手机号输入框
        mRegisterPhoneNumber = findViewById(R.id.Register_PhoneNumberEd);
        //手机验证码输入框
        mRegisterPhotoCodeEd = findViewById(R.id.Register_PhoneCodeEd);
        //手机获取验证码text
        mRegisterPhotoCode = findViewById(R.id.Register_PhotoCodeText);
        //下一步按钮
        mRegisterNextBtn = findViewById(R.id.Register_NextBtn);
        mRegisterReturn.setOnClickListener(this);
        mRegisterNextBtn.setOnClickListener(this);
        mRegisterPhotoCode.setOnClickListener(this);
        Intent intent = getIntent();
        isBind = intent.getStringExtra("bind");
        String userMobile = intent.getStringExtra("userMobile");
        if (isBind.equals("未绑定手机号")) {
            register_text.setText("绑定手机号");
            mRegisterNextBtn.setText("绑定");
        } else if (isBind.equals("已有手机号，更换绑定")) {
            register_text.setText("更换绑定");
            mRegisterNextBtn.setText("下一步");
        }
    }


    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Register_return:
                finish();
                break;
            case R.id.Register_PhotoCodeText:
                String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。

                //正则判断手机号
                 String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
                if (!mRegisterPhoneNumber.getText().toString().trim().matches(REGEX_MOBILE)) {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }
                if (mRegisterPhoneNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                } else {
//                    initpopu();
//               倒计时
                    smsCodeDownUtil = new SmsCodeDownUtil(mRegisterPhotoCode, "%s", 60);
                    smsCodeDownUtil.start();
                    String countdownText = smsCodeDownUtil.getCountdownText();
                    mRegisterPhotoCode.setText(countdownText);
                    presenter.sendAlartPhoneNumData(mRegisterPhoneNumber.getText().toString(), "1", "3233");
                }
                break;
            case R.id.Register_NextBtn:
                if (mRegisterPhoneNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                if (mRegisterPhotoCodeEd.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (register_text.getText().toString().equals("绑定手机号")) {
                        //        三方账号绑定手机号（手机未绑定过）
                        presenter.sendThirdBindData(mRegisterPhoneNumber.getText().toString()
                                , mRegisterPhotoCodeEd.getText().toString()
                                , (String) SPUtils.get(this, SPKey.LOGIN_TYPE, "")
                                , (String) SPUtils.get(this, SPKey.USER_OAUTHID, ""));
                    } else {
                        //  账号绑定前的密码校验
                        presenter.sendCheckCodeData(mRegisterPhoneNumber.getText().toString(), mRegisterPhotoCodeEd.getText().toString());

                    }
//                    presenter.getRegisterLoginCode(mRegisterPhoneNumber.getText().toString().trim(), mRegisterPhotoCodeEd.getText().toString().trim());
//                    requestPhotoCode(mRegisterPhoneNumber.getText().toString().trim());
//                    finish();
                }

                break;
            case R.id.image_code_reload_Btn:
                break;
            case R.id.image_code_return:
                window.dismiss();
                break;
            case R.id.image_code_sure_Btn:
//                presenter.getVerificationCode(mRegisterPhoneNumber.getText().toString().trim(), image_code_ed.getText().toString().trim());
                window.dismiss();
                break;

        }
    }

    public void gotoPassword() {
        Intent intent = new Intent(BindPhotoActivity.this, BindPhoneNumActivity.class);
        intent.putExtra("smsCode", mRegisterPhotoCodeEd.getText().toString().trim());
        intent.putExtra("phone", mRegisterPhoneNumber.getText().toString().trim());
        startActivity(intent);
        finish();
    }

    private void initpopu() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.fill_imagecode_popu, null, false);
        imageCode = contentView.findViewById(R.id.image_code_img);
        image_code_ed = contentView.findViewById(R.id.image_code_Ed);
        image_code_reload_btn = contentView.findViewById(R.id.image_code_reload_Btn);
        image_code_return = contentView.findViewById(R.id.image_code_return);
        image_code_sure_btn = contentView.findViewById(R.id.image_code_sure_Btn);
        requestPhotoCode(mRegisterPhoneNumber.getText().toString().trim());
        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        window = new PopupWindow(contentView, 540, 350, true);
        // 设置PopupWindow的背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        window.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        window.setTouchable(true);
        window.showAtLocation(mRegister_Code_Lin, Gravity.CENTER, 0, 0);
        //设置PopupWindow中View的点击事件
        image_code_reload_btn.setOnClickListener(this);
        image_code_return.setOnClickListener(this);
        image_code_sure_btn.setOnClickListener(this);
    }

    //请求图片验证码
    private void requestPhotoCode(String mobile) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        FormBody formBody = new FormBody.Builder()
                .add("mobile", mobile)
                .build();
        Request request = new Request.Builder().post(formBody).url(Urls.BASE_URL + Urls.REQUES_PICTURE_VERIFICATION_CODE).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("请求失败", e.toString());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Glide.with(BindPhotoActivity.this).load(response.body().bytes()).into(imageCode);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    //    成功获取验证码
    @Override
    public void showAlartPhoneNumData(VerificationCodeBean verificationCodeBean) {
        if (verificationCodeBean.getState() == 0) {
            Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
        }
    }

    //下一步（绑定新的手机号，去输入密码）
    @Override
    public void showCheckCodeData(VerificationCodeBean verificationCodeBean) {
        if (verificationCodeBean.getState() == 0) {
            gotoPassword();
        } else {
            Toast.makeText(this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    //    获取的验证码无效
    @Override
    public void showError() {
        Toast.makeText(this, "获取验证码失败", Toast.LENGTH_SHORT).show();
    }

    //        三方账号绑定手机号（手机未绑定过）
    @Override
    public void showThirdBindData(VerificationCodeBean verificationCodeBean) {
        if (verificationCodeBean.getState() == 0) {
//            如果成功的话就保存手机号到SP中
            SPUtils.put(this,SPKey.USER_MOBILE,mRegisterPhoneNumber.getText().toString());
            finish();
        } else {
            Toast.makeText(this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }
}
