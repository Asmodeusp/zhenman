package com.zhenman.asus.zhenman.view.message;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.ByFansContract;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.ByFansBean;
import com.zhenman.asus.zhenman.presenter.ByfansPresenter;
import com.zhenman.asus.zhenman.view.adapter.myself.MyAttenThemeAdapter;
import com.zhenman.asus.zhenman.view.myself.HomepageActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ByFansActivity extends BaseActivity<ByfansPresenter> implements ByFansContract.ByFansInView, MyAttenThemeAdapter.MyAttenThemeCallback {


    @BindView(R.id.app_back)
    AutoRelativeLayout appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.byFans_recy)
    RecyclerView byFansRecy;
    @BindView(R.id.byFans_none)
    TextView byFansNone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_by_fans;
    }

    @Override
    protected void init() {
        appTitle.setText("粉丝");
        presenter.sendByFansData("1", "20");

    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showError(String string) {

    }

    @Override
    public void showByFansData(final ByFansBean byFansBean) {
        if (byFansBean.getState() == 0) {
            List<ByFansBean.DataBean> result = byFansBean.getData();
            if (result.size() == 0) {
                byFansNone.setVisibility(View.VISIBLE);
                byFansRecy.setVisibility(View.GONE);
            } else {
                byFansNone.setVisibility(View.GONE);
                byFansRecy.setVisibility(View.VISIBLE);
                List<Object> list1 = new ArrayList<>();
                list1.addAll(result);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                byFansRecy.setLayoutManager(linearLayoutManager);
                MyAttenThemeAdapter myAttenThemeAdapter = new MyAttenThemeAdapter(list1, this);
                myAttenThemeAdapter.MyAttenThemeCallback(this);
                byFansRecy.setAdapter(myAttenThemeAdapter);
                myAttenThemeAdapter.setOnShortCLickListener(new MyAttenThemeAdapter.OnShortCLickListener() {
                    @Override
                    public void myClick(View view, int position) {
                        Intent intent = new Intent(ByFansActivity.this, HomepageActivity.class);
                        intent.putExtra("him_id", byFansBean.getData().get(position).getUserId() + "");
                        startActivity(intent);
                    }
                });
            }
        } else {
            Toast.makeText(this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    //关注用户
    @Override
    public void showAttentionUser(AttentionMyFansBean verificationCodeBean) {
        if (verificationCodeBean.getState() == 0) {
            Toast.makeText(this, verificationCodeBean.getMsg(), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "操作失败", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.app_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_back:
                finish();
                break;

        }
    }

    //关注
    @Override
    public void makeAttention(String subjectId, String status) {
        presenter.sendAttentionUserData(subjectId, status);
    }
}
