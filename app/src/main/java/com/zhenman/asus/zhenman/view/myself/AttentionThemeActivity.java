package com.zhenman.asus.zhenman.view.myself;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.MyAttenThemeContract;
import com.zhenman.asus.zhenman.model.bean.MyAttenThemeBean;
import com.zhenman.asus.zhenman.model.bean.ThemeAttentionBean;
import com.zhenman.asus.zhenman.presenter.MyAttenThemePresenter;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.myself.MyAttenThemeAdapter;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AttentionThemeActivity extends BaseActivity<MyAttenThemePresenter> implements View.OnClickListener, MyAttenThemeContract.MyAttenThemeInView, MyAttenThemeAdapter.MyAttenThemeCallback {

    @BindView(R.id.attentionTheme_none)
    TextView attentionThemeNone;
    private AutoRelativeLayout app_back;
    private TextView app_title;
    private TextView app_otherID;
    private ImageView app_otherImage;
    private RecyclerView attentionTheme_recy;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_attention_theme;
    }

    @Override
    protected void init() {
        app_back = (AutoRelativeLayout) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        app_otherID = (TextView) findViewById(R.id.app_otherID);
        app_otherImage = (ImageView) findViewById(R.id.app_otherImage);
        attentionTheme_recy = (RecyclerView) findViewById(R.id.attentionTheme_recy);
        if (getIntent().getStringExtra("him_id").equals("myself")) {
            app_title.setText("我的关注");
            presenter.sendMyAttenThemeData((String) SPUtils.get(this, SPKey.USER_ID, ""), 1 + "", 20 + "");
        } else {
            presenter.sendMyAttenThemeData(HomepageActivity.him_id, 1 + "", 20 + "");

        }
        app_title.setText("我关注的主题");
        app_otherImage.setVisibility(View.VISIBLE);
        app_otherImage.setImageResource(R.mipmap.common_search);
        idListener();
        presenter.sendMyAttenThemeData((String) SPUtils.get(this, SPKey.USER_ID, ""), 1 + "", 20 + "");
    }

    private void idListener() {
        app_back.setOnClickListener(this);
        app_otherImage.setOnClickListener(this);

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
            case R.id.app_otherImage:

                break;
        }
    }

    @Override
    public void showMyAttenTheme(MyAttenThemeBean myAttenThemeBean) {

        if (myAttenThemeBean.getState() == 0) {

            List<MyAttenThemeBean.DataBean.ResultBean> result = myAttenThemeBean.getData().getResult();
            if (result.size() == 0) {
                attentionThemeNone.setVisibility(View.VISIBLE);
                attentionTheme_recy.setVisibility(View.GONE);
            } else {
                attentionThemeNone.setVisibility(View.GONE);
                attentionTheme_recy.setVisibility(View.VISIBLE);
                List<Object> list1 = new ArrayList<>();
//                for (int i = 0; i < result.size(); i++) {
                    list1.addAll(result);
//                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                attentionTheme_recy.setLayoutManager(linearLayoutManager);
                MyAttenThemeAdapter myAttenThemeAdapter = new MyAttenThemeAdapter(list1, this);
                myAttenThemeAdapter.MyAttenThemeCallback(this);
                attentionTheme_recy.setAdapter(myAttenThemeAdapter);
            }
        } else {
            Toast.makeText(this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAttentionTheme(ThemeAttentionBean themeAttentionBean) {
        if (themeAttentionBean.getState() == 0) {
            Toast.makeText(this, themeAttentionBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    //    关注主题的回调
    @Override
    public void makeAttention(String subjectId, String status) {
        presenter.sendAttentionThemeData(subjectId, status + "");
    }


}
