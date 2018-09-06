package com.zhenman.asus.zhenman.view.myself;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyLikeFragment;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyWorkFragment;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

public class HomepageActivity extends BaseActivity implements View.OnClickListener {

    private ImageView app_back;
    private TextView app_title;
    private TextView app_otherID;
    private ImageView homePage_Avatar;
    private TextView homePage_Name;
    private ImageView homePage_Sex;
    private TextView my_Resume;
    private TextView homePage_works;
    private TextView homePage_fans;
    private TextView homePage_attention;
    private TextView homePage_theme;
    private AutoLinearLayout homePage_other01;
    private TextView homePage_other02;
    private TextView homePage_other03;
    private TextView homePage_other04;
    private TextView homePage_other05;
    private AutoRelativeLayout my_data;
    private TextView homePage_myWorks;
    private TextView homePage_myLike;
    private View homePage_other06;
    private View homePage_other07;
    private TabLayout homePage_myWorksTab;
    private FrameLayout homePage_myWorkContainer;
    private AutoLinearLayout homePage_MyWorkPage;
    private AutoLinearLayout homePage_myLikePage;
    private ArrayList<String> homePageTab_title;
    private ArrayList<Fragment> homePageTab_fragment;
    private HomePageMyWorkFragment homePageMyWorkFragment;
    private HomePageMyLikeFragment homePageMyLikeFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_homepage;
    }

    @Override
    protected void init() {
        app_back = (ImageView) findViewById(R.id.app_back);
        app_title = (TextView) findViewById(R.id.app_title);
        app_otherID = (TextView) findViewById(R.id.app_otherID);
        homePage_Avatar = (ImageView) findViewById(R.id.homePage_Avatar);
        homePage_Name = (TextView) findViewById(R.id.homePage_Name);
        homePage_Sex = (ImageView) findViewById(R.id.homePage_Sex);
        my_Resume = (TextView) findViewById(R.id.my_Resume);
        homePage_works = (TextView) findViewById(R.id.homePage_works);
        homePage_fans = (TextView) findViewById(R.id.homePage_fans);
        homePage_attention = (TextView) findViewById(R.id.homePage_attention);
        homePage_theme = (TextView) findViewById(R.id.homePage_theme);
        homePage_other01 = (AutoLinearLayout) findViewById(R.id.homePage_other01);
        homePage_other02 = (TextView) findViewById(R.id.homePage_other02);
        homePage_other03 = (TextView) findViewById(R.id.homePage_other03);
        homePage_other04 = (TextView) findViewById(R.id.homePage_other04);
        homePage_other05 = (TextView) findViewById(R.id.homePage_other05);
        my_data = (AutoRelativeLayout) findViewById(R.id.my_data);
        homePage_myWorks = (TextView) findViewById(R.id.homePage_myWorks);
        homePage_myLike = (TextView) findViewById(R.id.homePage_myLike);
        homePage_other06 = (View) findViewById(R.id.homePage_other06);
        homePage_other07 = (View) findViewById(R.id.homePage_other07);
        homePage_myWorksTab = (TabLayout) findViewById(R.id.homePage_myWorksTab);
        homePage_myWorkContainer = (FrameLayout) findViewById(R.id.homePage_myWorkContainer);
        homePage_MyWorkPage = (AutoLinearLayout) findViewById(R.id.homePage_MyWorkPage);
        homePage_myLikePage = (AutoLinearLayout) findViewById(R.id.homePage_myLikePage);
        app_title.setVisibility(View.GONE);
        homePageTab_title = new ArrayList<>();
        homePageTab_fragment = new ArrayList<>();
        homePageMyWorkFragment = new HomePageMyWorkFragment();
        homePageMyLikeFragment = new HomePageMyLikeFragment();
        homePageTab_title.add("TA的作品");
        homePageTab_title.add("TA的喜欢");
        homePageTab_fragment.add(homePageMyWorkFragment);
        homePageTab_fragment.add(homePageMyLikeFragment);


        idListener();

    }

    private void idListener() {
        app_back.setOnClickListener(this);
        homePage_myWorks.setOnClickListener(this);
        homePage_myLike.setOnClickListener(this);


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
            case R.id.homePage_myWorks:
                homePage_other07.setVisibility(View.GONE);
                homePage_other06.setVisibility(View.VISIBLE);
                break;
            case R.id.homePage_myLike:
                homePage_other07.setVisibility(View.VISIBLE);
                homePage_other06.setVisibility(View.GONE);

                break;
        }
    }
}
