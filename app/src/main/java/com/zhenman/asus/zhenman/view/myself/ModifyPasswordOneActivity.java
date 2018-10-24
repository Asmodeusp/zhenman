package com.zhenman.asus.zhenman.view.myself;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.zhy.autolayout.AutoLinearLayout;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ModifyPasswordOneActivity extends BaseActivity implements View.OnClickListener {


    private ImageView app_back;
    private TextView app_title;
    private EditText modifyPsOne_enterPhone;
    private CheckBox modifyPsOne_lookPs;
    private Button modifyPsOne_next;
    private EditText modifyPsOne_enterCode;
    private TextView modifyPsOne_getCode;
    private PopupWindow window;
    private LinearLayout image_code_reload_btn;
    private ImageView image_code_return;
    private TextView image_code_sure_btn;
    private ImageView imageCode;
    private EditText image_code_ed;
    private AutoLinearLayout modifyPsOne;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_password_one;
    }

    @Override
    protected void init() {
        app_back = findViewById(R.id.app_back);//返回
        app_title = findViewById(R.id.app_title);//标题
        modifyPsOne_enterPhone = findViewById(R.id.modifyPsOne_enterPhone);//手机号
        modifyPsOne_enterCode = findViewById(R.id.modifyPsOne_enterCode);//验证码
        modifyPsOne_getCode = findViewById(R.id.modifyPsOne_getCode);//得到验证码
        modifyPsOne_next = findViewById(R.id.modifyPsOne_next);//下一步
        app_title.setText("修改密码");
        idListener();
    }

    private void idListener() {
        app_back.setOnClickListener(this);

        modifyPsOne_getCode.setOnClickListener(this);
        modifyPsOne_next.setOnClickListener(this);

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

            case R.id.modifyPsOne_getCode:
                String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
                if (!modifyPsOne_enterPhone.getText().toString().trim().matches(telRegex)) {
                    Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
                } else if (modifyPsOne_enterPhone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    initpopu();
                }
                break;
            case R.id.modifyPsOne_next:
                break;
            case R.id.image_code_reload_Btn:
                requestPhotoCode(modifyPsOne_enterPhone.getText().toString().trim());
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
        requestPhotoCode(modifyPsOne_enterPhone.getText().toString().trim());
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
        window.showAtLocation(modifyPsOne, Gravity.CENTER, 0, 0);
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
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Glide.with(ModifyPasswordOneActivity.this).load(response.body().bytes()).into(imageCode);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }


}
