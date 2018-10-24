package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.MyAttentionUserContract;
import com.zhenman.asus.zhenman.model.bean.AttentionMyFansBean;
import com.zhenman.asus.zhenman.model.bean.MyAttentionUserBean;
import com.zhenman.asus.zhenman.presenter.MyAttentionUserPresenter;
import com.zhenman.asus.zhenman.view.adapter.myself.MyAttenThemeAdapter;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyAttentionActivity extends BaseActivity<MyAttentionUserPresenter> implements MyAttentionUserContract.MyAttentionUserInView, MyAttenThemeAdapter.MyAttenThemeCallback {

    @BindView(R.id.app_back)
    AutoRelativeLayout appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.app_otherID)
    TextView appOtherID;
    @BindView(R.id.app_otherImage)
    ImageView appOtherImage;
    @BindView(R.id.myAttention_recy)
    RecyclerView myAttentionRecy;
    @BindView(R.id.myAttention_none)
    TextView myAttentionNone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_attention;

    }

    @Override
    protected void init() {
        if (HomepageActivity.him_id.equals("myself")) {
            appTitle.setText("我的关注");
            presenter.sendMyAttentionUserData("1", "20", "");
        } else {
            appTitle.setText("TA的关注");
            presenter.sendMyAttentionUserData("1", "20", HomepageActivity.him_id);

        }

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

    //    得到关注列表
    @Override
    public void showMyAttentionUserData(MyAttentionUserBean attentionUserBean) {

        List<MyAttentionUserBean.DataBean.ResultBean> result = attentionUserBean.getData().getResult();
        if (result.size() == 0) {
            myAttentionNone.setVisibility(View.VISIBLE);
            myAttentionRecy.setVisibility(View.GONE);

        } else {
            myAttentionNone.setVisibility(View.GONE);
            myAttentionRecy.setVisibility(View.VISIBLE);
            List<Object> list1 = new ArrayList<>();
            list1.addAll(result);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            myAttentionRecy.setLayoutManager(linearLayoutManager);
            MyAttenThemeAdapter myAttenThemeAdapter = new MyAttenThemeAdapter(list1, this);
            myAttenThemeAdapter.MyAttenThemeCallback(this);
            myAttentionRecy.setAdapter(myAttenThemeAdapter);
        }
    }

    //    展示错误信息
    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    //    关注用户的回调
    @Override
    public void showAttentionUser(AttentionMyFansBean verificationCodeBean) {
        Toast.makeText(this, verificationCodeBean.getMsg(), Toast.LENGTH_SHORT).show();

    }

    //关注
    @Override
    public void makeAttention(String subjectId, String status) {
        presenter.sendAttentionUserData(subjectId, status);
    }
}
