package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class EggplantDetailsActivity extends BaseActivity {


    @BindView(R.id.app_back)
    AutoRelativeLayout appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.app_otherImage)
    ImageView appOtherImage;
    @BindView(R.id.eggplantDetails_list)
    RecyclerView eggplantDetailsList;
    @BindView(R.id.app_otherID)
    TextView appOtherID;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_eggplant_details;
    }

    @Override
    protected void init() {
        appTitle.setText("茄子明细");
        appOtherID.setText("帮助");

    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.app_back, R.id.app_otherID})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_back:
                finish();
                break;
            case R.id.app_otherID:
                break;
        }
    }


}
