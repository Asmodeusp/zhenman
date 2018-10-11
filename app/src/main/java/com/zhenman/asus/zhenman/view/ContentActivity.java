package com.zhenman.asus.zhenman.view;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.view.fragment.HomepageFragment;
import com.zhenman.asus.zhenman.view.fragment.MessageFragment;
import com.zhenman.asus.zhenman.view.fragment.MyselfFragment;
import com.zhenman.asus.zhenman.view.fragment.SerializationFragment;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

public class ContentActivity extends BaseActivity implements View.OnClickListener {
    public AutoFrameLayout contentview;
    public TextView HomeText;
    private AutoRelativeLayout HomeButton;
    private AutoRelativeLayout SerializationButton;
    private AutoRelativeLayout ReleaseButton;
    private AutoRelativeLayout MessageButton;
    private AutoRelativeLayout MyselfButton;
    public AutoLinearLayout group;
    private TextView SerializationText;

    public AutoLinearLayout getGroup() {
        return group;
    }

    private TextView MessageText;
    private TextView MyselfText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override
    protected void init() {
        initView();
    }

    private void initView() {
        HomeText = findViewById(R.id.HomeText);
        SerializationText = findViewById(R.id.SerializationText);
        MessageText = findViewById(R.id.MessageText);
        MyselfText = findViewById(R.id.MyselfText);
        HomeButton = findViewById(R.id.HomeButton);
        SerializationButton = findViewById(R.id.SerializationButton);
        ReleaseButton = findViewById(R.id.ReleaseButton);
        MessageButton = findViewById(R.id.MessageButton);
        MyselfButton = findViewById(R.id.MyselfButton);
        group = findViewById(R.id.group);
        HomeButton.setOnClickListener(this);
        SerializationButton.setOnClickListener(this);
        ReleaseButton.setOnClickListener(this);
        MessageButton.setOnClickListener(this);
        MyselfButton.setOnClickListener(this);
        setContentView(R.id.Homecontentview, HomepageFragment.class);
        setText(36, 32, 32, 32);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.HomeButton:
                group.setBackgroundColor(this.getResources().getColor(R.color.touming));
                setContentView(R.id.Homecontentview, HomepageFragment.class);
                setText(38, 32, 32, 32);
                setTextColor("#ffffff");

                break;
            case R.id.SerializationButton:
                group.setBackgroundColor(Color.parseColor("#ffffff"));
                setContentView(R.id.Othercontentview, SerializationFragment.class);
                setText(32, 38, 32, 32);
                setTextColor("#000000");
                break;
            case R.id.ReleaseButton:
//           setContentView(R.id.contentview, IntroducedFragment.class);
                Toast.makeText(this, "该功能暂未开放", Toast.LENGTH_SHORT).show();
                break;
            case R.id.MessageButton:
                group.setBackgroundColor(Color.parseColor("#ffffff"));
                setContentView(R.id.Othercontentview, MessageFragment.class);
                setText(32, 32, 38, 32);
                setTextColor("#000000");

                break;
            case R.id.MyselfButton:
                group.setBackgroundColor(Color.parseColor("#ffffff"));
                setContentView(R.id.Othercontentview, MyselfFragment.class);
                setText(32, 32, 32, 38);
                setTextColor("#000000");
                break;

        }
    }

    //设置字体颜色
    private void setTextColor(String color) {
        HomeText.setTextColor(Color.parseColor(color));
        SerializationText.setTextColor(Color.parseColor(color));
        MessageText.setTextColor(Color.parseColor(color));
        MyselfText.setTextColor(Color.parseColor(color));
    }

    //设置字体大小
    private void setText(int home, int serialization, int message, int myself) {
        HomeText.setTextSize(TypedValue.COMPLEX_UNIT_PX, home);
        SerializationText.setTextSize(TypedValue.COMPLEX_UNIT_PX, serialization);
        MessageText.setTextSize(TypedValue.COMPLEX_UNIT_PX, message);
        MyselfText.setTextSize(TypedValue.COMPLEX_UNIT_PX, myself);
    }
}
