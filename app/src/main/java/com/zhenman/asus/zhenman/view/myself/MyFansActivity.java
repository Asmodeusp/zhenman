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
import com.zhenman.asus.zhenman.contract.MyFansContract;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.MyFansBean;
import com.zhenman.asus.zhenman.presenter.MyFansPresenter;
import com.zhenman.asus.zhenman.view.adapter.myself.MyAttenThemeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFansActivity extends BaseActivity<MyFansPresenter> implements MyFansContract.MyFansInView, MyAttenThemeAdapter.MyAttenThemeCallback {

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
        appTitle.setText("我的粉丝");
//        发送请求获取用户粉丝列表
        presenter.sendMyFansData("1", "20");
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

    //    用户粉丝列表
    @Override
    public void showMyFansData(MyFansBean myFansBean) {
        if (myFansBean.getState() == 0) {
            List<MyFansBean.DataBean.ResultBean> result = myFansBean.getData().getResult();
            if (result.size() == 0) {
                myFansNone.setVisibility(View.VISIBLE);
                myFansRecy.setVisibility(View.GONE);
            } else {
                for (int i = 0; i < result.size(); i++) {

                }
                myFansNone.setVisibility(View.GONE);
                myFansRecy.setVisibility(View.VISIBLE);
                List<Object> list1 = new ArrayList<>();
                list1.addAll(result);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                myFansRecy.setLayoutManager(linearLayoutManager);
                MyAttenThemeAdapter myAttenThemeAdapter = new MyAttenThemeAdapter(list1, this);
                myAttenThemeAdapter.MyAttenThemeCallback(this);
                myFansRecy.setAdapter(myAttenThemeAdapter);
            }
        } else {
            Toast.makeText(this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    //    关注用户
    @Override
    public void showAttentionUser(AttentionMyFansBean verificationCodeBean) {
        if (verificationCodeBean.getState() == 0) {
            Toast.makeText(this, verificationCodeBean.getMsg(), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "操作失败", Toast.LENGTH_SHORT).show();
        }
    }

    //    关注用户
    @Override
    public void makeAttention(String subjectId, String status) {
        presenter.sendAttentionUserData(subjectId, status);
    }
}
