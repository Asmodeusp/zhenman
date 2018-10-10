package com.zhenman.asus.zhenman.view.message;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.ThemeDetailHeadContract;
import com.zhenman.asus.zhenman.model.bean.ThemeDetailHeadBean;
import com.zhenman.asus.zhenman.presenter.ThemeDetailsPresenter;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.message.MessageAdapter;
import com.zhenman.asus.zhenman.view.message.fragment.FeaturedFragment;
import com.zhenman.asus.zhenman.view.message.fragment.SquareFragment;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ThemeDetailsActivity extends BaseActivity<ThemeDetailsPresenter> implements View.OnClickListener, ThemeDetailHeadContract.ThemeDetailHeadInView {

    private ImageView app_back;
    private TextView app_title;
    private TextView app_otherID;
    private ImageView app_otherImage;
    private CircleImageView themeDetail_Avatar;
    private ImageView themeDetail_Common;
    private TextView themeDetail_Name;
    private TextView themeDetail_introduction;
    private TextView themeDetail_attenNum;
    private TextView themeDetail_attention;
    private AutoRelativeLayout themeDetail_data;
    private TabLayout themeDetail_himTab;
    private ViewPager themeDetail_Viewpager;
    private List<String> title_List;
    private List<Fragment> frag_List;
    private FeaturedFragment featuredFragment;
    private SquareFragment squareFragment;
    private String chapterId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_theme_details;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        chapterId = intent.getStringExtra("chapterId");
        app_back = (ImageView) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        app_otherID = (TextView) findViewById(R.id.app_otherID);
        app_otherImage = (ImageView) findViewById(R.id.app_otherImage);
        themeDetail_Avatar = (CircleImageView) findViewById(R.id.themeDetail_Avatar);
        themeDetail_Common = (ImageView) findViewById(R.id.themeDetail_Common);
        themeDetail_Name = (TextView) findViewById(R.id.themeDetail_Name);
        themeDetail_introduction = (TextView) findViewById(R.id.themeDetail_introduction);
        themeDetail_attenNum = (TextView) findViewById(R.id.themeDetail_attenNum);
        themeDetail_attention = (TextView) findViewById(R.id.themeDetail_attention);
        themeDetail_data = (AutoRelativeLayout) findViewById(R.id.themeDetail_data);
        themeDetail_himTab = (TabLayout) findViewById(R.id.themeDetail_himTab);
        themeDetail_Viewpager = (ViewPager) findViewById(R.id.themeDetail_Viewpager);
        app_title.setText("");
        Boolean isAttention = (Boolean) SPUtils.get(this, SPKey.ATTENTION_THEME, false);
        if (isAttention){
            themeDetail_attention.setText("已关注");
            themeDetail_attention.setTextColor(Color.parseColor("#40a9ff"));
            themeDetail_attention.setBackgroundResource(R.drawable.yiguanzhu);
        }else {
            themeDetail_attention.setText("关注主题");
            themeDetail_attention.setTextColor(Color.parseColor("#ffffff"));
            themeDetail_attention.setBackgroundResource(R.drawable.guanzhuzhuti);
        }
        idListener();
        initData();
    }

    private void initData() {
        title_List = new ArrayList<>();
        frag_List = new ArrayList<>();
        featuredFragment = new FeaturedFragment();
        squareFragment = new SquareFragment();
        title_List.add("精选");
        title_List.add("广场");
        frag_List.add(featuredFragment);
        frag_List.add(squareFragment);
        themeDetail_himTab.setupWithViewPager(themeDetail_Viewpager);
        MessageAdapter messageAdapter = new MessageAdapter(getSupportFragmentManager(), title_List, frag_List);
        themeDetail_Viewpager.setAdapter(messageAdapter);
        presenter.sendThemeDetailHeadData(chapterId);
    }

    @Override
    protected void loadDate() {

    }

    private void idListener() {
        app_back.setOnClickListener(this);
        themeDetail_attention.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.themeDetail_attention:

                break;
        }
    }

    //    获取主题详情头部信息
    @Override
    public void showThemeDetailHeadData(ThemeDetailHeadBean themeDetailHeadBean) {
        if (themeDetailHeadBean.getState() == 0) {
            Glide.with(this).load(themeDetailHeadBean.getData().getImage()).into(themeDetail_Avatar);
            themeDetail_Name.setText(themeDetailHeadBean.getData().getName());
            themeDetail_introduction.setText(themeDetailHeadBean.getData().getDescription());
            themeDetail_attenNum.setText(themeDetailHeadBean.getData().getFollowNum() + "人关注");
        } else if (themeDetailHeadBean.getData().getName().isEmpty()) {
            Toast.makeText(this, "获取数据失败", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(String string) {

    }

}
