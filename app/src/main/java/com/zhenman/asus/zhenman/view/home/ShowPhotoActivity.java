package com.zhenman.asus.zhenman.view.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.model.bean.HomeAttentionBean;
import com.zhenman.asus.zhenman.view.adapter.home.HomeAttentionShowVpAdapter;
import java.util.ArrayList;
import butterknife.BindView;
public class ShowPhotoActivity extends BaseActivity {

    private ArrayList<Fragment>  fragments = new ArrayList<>();
    @BindView(R.id.show_photo_ViewPager)
    ViewPager showPhotoViewPager;
    private HomeAttentionBean.DataBean.ResultBean resultBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_photo;
    }


    @Override
    protected void init() {
        Intent intent = getIntent();
        resultBean = (HomeAttentionBean.DataBean.ResultBean) intent.getSerializableExtra("ResultBean");
        if (resultBean!=null) {
            for (HomeAttentionBean.DataBean.ResultBean.ImgListBean imgListBean : resultBean.getImgList()) {
                String finalImg = imgListBean.getFinalImg();
                ShowPhotoFragment showPhotoFragment = new ShowPhotoFragment();
                fragments.add(showPhotoFragment);
                Bundle bundle = new Bundle();
                bundle.putString("finalImg",finalImg);
                showPhotoFragment.setArguments(bundle);
            }
        }
        HomeAttentionShowVpAdapter homeAttentionShowVpAdapter = new HomeAttentionShowVpAdapter(getSupportFragmentManager(), fragments);
        showPhotoViewPager.setAdapter(homeAttentionShowVpAdapter);
    }

    @Override
    protected void loadDate() {


    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_open,R.anim.activity_close);
    }
}
