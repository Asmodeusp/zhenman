package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.EggplantDetailsContract;
import com.zhenman.asus.zhenman.model.bean.EggplantDetailsBean;
import com.zhenman.asus.zhenman.presenter.EggplantDetailsPresenter;
import com.zhenman.asus.zhenman.view.adapter.myself.EggplantDetailsAdapter;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EggplantDetailsActivity extends BaseActivity<EggplantDetailsPresenter> implements EggplantDetailsContract.EggplantDetailsInView {


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

        presenter.sendEggplantDetailsData("1","20");
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


    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEggplantDetailsData(EggplantDetailsBean eggplantDetailsBean) {
        if (eggplantDetailsBean.getData().size()==0) {
            eggplantDetailsList.setVisibility(View.GONE);
        }else {
            eggplantDetailsList.setVisibility(View.VISIBLE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            eggplantDetailsList.setLayoutManager(linearLayoutManager);
            List<EggplantDetailsBean.DataBean> dataBeanList = eggplantDetailsBean.getData();
            Log.e("Sunny",dataBeanList.toString());
            EggplantDetailsAdapter eggplantDetailsAdapter = new EggplantDetailsAdapter(dataBeanList, this);
            eggplantDetailsList.setAdapter(eggplantDetailsAdapter);
        }
    }
}
