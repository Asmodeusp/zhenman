package com.zhenman.asus.zhenman.view.myself;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhy.autolayout.AutoRelativeLayout;

public class MySettingActivity extends BaseActivity implements View.OnClickListener {


    private ImageView set_Back;
    private CheckBox set_MessageNotification;
    private TextView set_CacheSize;
    private AutoRelativeLayout setting_clearCache;
    private AutoRelativeLayout setting_customeFeedback;
    private TextView set_UpdateNumber;
    private AutoRelativeLayout setting_update;
    private AutoRelativeLayout setting_aboutZhenman;
    private AutoRelativeLayout set_Cancellation;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_setting;
    }

    @Override
    protected void init() {
        set_Back = findViewById(R.id.set_Back);//       退出
        set_MessageNotification = findViewById(R.id.set_MessageNotification);//       消息通知
        set_CacheSize = findViewById(R.id.set_CacheSize);//       缓存大小
        setting_clearCache = findViewById(R.id.setting_clearCache);//       清除缓存
        setting_customeFeedback = findViewById(R.id.setting_customeFeedback);//       用户反馈
        set_UpdateNumber = findViewById(R.id.set_UpdateNumber);//       当前版本号
        setting_update = findViewById(R.id.setting_update);//       更新
        setting_aboutZhenman = findViewById(R.id.setting_aboutZhenman);//       关于真漫
        set_Cancellation = findViewById(R.id.set_Cancellation);//       退出登陆
        idListener();


    }

    private void idListener() {
        set_Back.setOnClickListener(this);
        set_MessageNotification.setOnClickListener(this);
        setting_clearCache.setOnClickListener(this);
        setting_customeFeedback.setOnClickListener(this);
        setting_update.setOnClickListener(this);
        setting_aboutZhenman.setOnClickListener(this);
        set_Cancellation.setOnClickListener(this);

    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_Back:
                finish();
                break;
            case R.id.set_MessageNotification:
                if (set_MessageNotification.isChecked()){
                    set_MessageNotification.setButtonDrawable(R.drawable.edit_outline_button_on);
                }else {
                    set_MessageNotification.setButtonDrawable(R.drawable.edit_outline_button_off);

                }
                break;
            case R.id.setting_clearCache:
                break;
            case R.id.setting_customeFeedback:
                break;
            case R.id.setting_update:
                break;
            case R.id.setting_aboutZhenman:
                break;
            case R.id.set_Cancellation:
                break;
        }
    }
}
