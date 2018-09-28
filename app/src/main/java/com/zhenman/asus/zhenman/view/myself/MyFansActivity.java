package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFansActivity extends BaseActivity {

    @BindView(R.id.app_back)
    ImageView appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.app_otherID)
    TextView appOtherID;
    @BindView(R.id.app_otherImage)
    ImageView appOtherImage;
    @BindView(R.id.myFans_recy)
    RecyclerView myFansRecy;
    @BindView(R.id.myFans_none)
    TextView myFansNone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_fans;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.app_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_back:
                finish();
                break;

        }
    }
}
