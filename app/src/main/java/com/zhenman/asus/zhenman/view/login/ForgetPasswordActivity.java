package com.zhenman.asus.zhenman.view.login;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.zhenman.asus.zhenman.utils.Urls;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ForgetPasswordActivity extends BaseActivity implements View.OnClickListener {

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
        register_text.setText("忘记密码");
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
//设置EditText文本框输入监听事件
        mRegisterPhoneNumber.addTextChangedListener(textWatcher);
        mRegisterPhotoCodeEd.addTextChangedListener(textWatcher);
        mRegisterReturn.setOnClickListener(this);
        mRegisterNextBtn.setOnClickListener(this);
        mRegisterPhotoCode.setOnClickListener(this);


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
                if (!mRegisterPhoneNumber.getText().toString().trim().matches(telRegex)) {
                    Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
                } else if (mRegisterPhoneNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    initpopu();
                }
                break;
            case R.id.Register_NextBtn:
                if (mRegisterPhoneNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                if (mRegisterPhotoCodeEd.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    finish();
                }

                break;
            case R.id.image_code_reload_Btn:
                requestPhotoCode(mRegisterPhoneNumber.getText().toString().trim());
                break;
            case R.id.image_code_return:
                window.dismiss();
                break;
            case R.id.image_code_sure_Btn:
                window.dismiss();
                break;

        }
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
        Request request = new Request.Builder()
                .post(formBody)
                .url(Urls.BASE_URL + Urls.REQUES_PICTURE_VERIFICATION_CODE)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, final Response response){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(ForgetPasswordActivity.this).load(response.body()).into(imageCode);
                    }
                });
            }
        });
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

            if (mRegisterPhoneNumber.getText().toString().isEmpty() || mRegisterPhotoCodeEd.getText().toString().isEmpty()) {
                mRegisterNextBtn.setAlpha(0.5f);
            } else {
                mRegisterNextBtn.setAlpha(1.0f);
            }
        }
    };
}



