package com.zhenman.asus.zhenman.view.myself;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.HomePageContract;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.presenter.HomePagePresenter;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.adapter.myself.HomePageAdapter;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyLikeFragment;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyWorkFragment;
import com.zhenman.asus.zhenman.view.ui.NoSrcollViewPage;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomepageActivity extends BaseActivity<HomePagePresenter> implements View.OnClickListener, HomePageContract.HomePageInView {

    private ImageView app_back;
    private TextView app_title;
    private TextView app_otherID;
    private CircleImageView homePage_Avatar;
    private TextView homePage_Name;
    private ImageView homePage_Sex;
    private TextView my_Resume;
    private TextView homePage_works;
    private TextView homePage_fans;
    private TextView homePage_attention;
    private TextView homePage_theme;
    private AutoLinearLayout homePage_other01;

    private AutoRelativeLayout my_data;
    private TabLayout homePage_himTab;
    private NoSrcollViewPage HomePage_Viewpager;
    private ArrayList<String> homePageTab_title;
    private ArrayList<Fragment> homePageTab_fragment;
    private HomePageMyWorkFragment homePageMyWorkFragment;
    private HomePageMyLikeFragment homePageMyLikeFragment;
    private AutoLinearLayout homePage_worksPage;
    private AutoLinearLayout homePage_fansPage;
    private AutoLinearLayout homePage_attentionPage;
    private AutoLinearLayout homePage_themePage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_homepage;
    }

    @Override
    protected void init() {
        app_back = (ImageView) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        app_otherID = (TextView) findViewById(R.id.app_otherID);
        homePage_Avatar = (CircleImageView) findViewById(R.id.homePage_Avatar);
        homePage_Name = (TextView) findViewById(R.id.homePage_Name);
        homePage_Sex = (ImageView) findViewById(R.id.homePage_Sex);
        my_Resume = (TextView) findViewById(R.id.my_Resume);
        homePage_works = (TextView) findViewById(R.id.homePage_works);
        homePage_fans = (TextView) findViewById(R.id.homePage_fans);
        homePage_attention = (TextView) findViewById(R.id.homePage_attention);
        homePage_theme = (TextView) findViewById(R.id.homePage_theme);
        homePage_worksPage = (AutoLinearLayout) findViewById(R.id.homePage_worksPage);
        homePage_fansPage = (AutoLinearLayout) findViewById(R.id.homePage_fansPage);
        homePage_attentionPage = (AutoLinearLayout) findViewById(R.id.homePage_attentionPage);
        homePage_themePage = (AutoLinearLayout) findViewById(R.id.homePage_themePage);
        my_data = (AutoRelativeLayout) findViewById(R.id.my_data);
        homePage_himTab = (TabLayout) findViewById(R.id.homePage_himTab);
        HomePage_Viewpager = (NoSrcollViewPage) findViewById(R.id.HomePage_Viewpager);
        app_title.setVisibility(View.GONE);
        homePageTab_title = new ArrayList<>();
        homePageTab_fragment = new ArrayList<>();
        homePageMyWorkFragment = new HomePageMyWorkFragment();
        homePageMyLikeFragment = new HomePageMyLikeFragment();
        homePageTab_title.add("TA的作品");
        homePageTab_title.add("TA喜欢的");
        homePageTab_fragment.add(homePageMyWorkFragment);
        homePageTab_fragment.add(homePageMyLikeFragment);
        presenter.sendHomePageHeadData((String) SPUtils.get(this, SPKey.USER_ID, ""));
        idListener();
        homePage_himTab.setupWithViewPager(HomePage_Viewpager);
        HomePageAdapter homePageAdapter = new HomePageAdapter(getSupportFragmentManager(), homePageTab_title, homePageTab_fragment);
        HomePage_Viewpager.setAdapter(homePageAdapter);
    }

    private void idListener() {
        app_back.setOnClickListener(this);
        homePage_themePage.setOnClickListener(this);
        homePage_attentionPage.setOnClickListener(this);
        homePage_fansPage.setOnClickListener(this);
        homePage_worksPage.setOnClickListener(this);
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
            case R.id.homePage_attentionPage:
                startActivity(new Intent(HomepageActivity.this, MyAttentionActivity.class));
                break;
            case R.id.homePage_fansPage:
                startActivity(new Intent(HomepageActivity.this, MyFansActivity.class));
                break;
            case R.id.homePage_themePage:
                startActivity(new Intent(HomepageActivity.this, AttentionThemeActivity.class));
                break;
            case R.id.homePage_worksPage:
                startActivity(new Intent(HomepageActivity.this, HomepageActivity.class));
                break;

        }
    }

    @Override
    public void showHomePageHead(HomePageHeadBean homePageHeadBean) {
        if (homePageHeadBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            Glide.with(this).load(homePageHeadBean.getData().getHeadImg()).into(homePage_Avatar);
            homePage_Name.setText(homePageHeadBean.getData().getName());
            if ("2".equals(homePageHeadBean.getData().getSex())) {
                homePage_Sex.setImageResource(R.mipmap.my_f);
            } else {
                homePage_Sex.setImageResource(R.mipmap.my_m);
            }
            my_Resume.setText(homePageHeadBean.getData().getIntroduction());
            homePage_works.setText(homePageHeadBean.getData().getWorks() + "");
            homePage_fans.setText(homePageHeadBean.getData().getFans() + "");
            homePage_attention.setText(homePageHeadBean.getData().getFollows() + "");
            homePage_theme.setText(homePageHeadBean.getData().getFollowSubject() + "");
        } else {
            Toast.makeText(this, "未获取到数据", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
