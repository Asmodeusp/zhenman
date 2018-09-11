package com.zhenman.asus.zhenman.view.myself;

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
import com.zhenman.asus.zhenman.contract.HomePageContract;
import com.zhenman.asus.zhenman.model.bean.HomePageHeadBean;
import com.zhenman.asus.zhenman.presenter.HomePagePresenter;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.view.adapter.myself.HomePageAdapter;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyLikeFragment;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyWorkFragment;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

public class HomepageActivity extends BaseActivity<HomePagePresenter> implements View.OnClickListener, HomePageContract.HomePageInView {

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
    private ViewPager homePage_myWorkContainer;
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
        homePage_myWorkContainer = (ViewPager) findViewById(R.id.homePage_myWorkContainer);
        homePage_MyWorkPage = (AutoLinearLayout) findViewById(R.id.homePage_MyWorkPage);
        homePage_myLikePage = (AutoLinearLayout) findViewById(R.id.homePage_myLikePage);
        app_title.setVisibility(View.GONE);
        homePageTab_title = new ArrayList<>();
        homePageTab_fragment = new ArrayList<>();
        homePageMyWorkFragment = new HomePageMyWorkFragment();
        homePageMyLikeFragment = new HomePageMyLikeFragment();
        homePageTab_title.add("短漫画");
        homePageTab_title.add("长漫画");
        homePageTab_fragment.add(homePageMyWorkFragment);
        homePageTab_fragment.add(homePageMyLikeFragment);
        idListener();
        presenter.sendHomePageHeadData("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1MjAzNDMsInN1YiI6IntcInVzZXJJZFwiOjI2MCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiQzY3ODlDMDkyQTZFRkI4ODE0Qzk2RUQ0NzAzQTEyQzBcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NDA1NjM0M30.Cz4w8ArY8w_Ct78D2Y4ZMPz4GrXQD3NNM4lKwz-V9m0", "255");

        homePage_myWorksTab.setupWithViewPager(homePage_myWorkContainer);
        HomePageAdapter homePageAdapter = new HomePageAdapter(getSupportFragmentManager(), homePageTab_title, homePageTab_fragment);
        homePage_myWorkContainer.setAdapter(homePageAdapter);
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
                homePage_MyWorkPage.setVisibility(View.VISIBLE);
                homePage_myWorks.setTextColor(homePage_myWorks.getResources().getColor(R.color.c1));
                homePage_myLike.setTextColor(homePage_myLike.getResources().getColor(R.color.h3));

                break;
            case R.id.homePage_myLike:
                homePage_other07.setVisibility(View.VISIBLE);
                homePage_other06.setVisibility(View.GONE);
                homePage_myLikePage.setVisibility(View.VISIBLE);
                homePage_MyWorkPage.setVisibility(View.GONE);
                homePage_myWorks.setTextColor(homePage_myWorks.getResources().getColor(R.color.h3));
                homePage_myLike.setTextColor(homePage_myLike.getResources().getColor(R.color.c1));
                break;
        }
    }

    @Override
    public void showHomePageHead(HomePageHeadBean homePageHeadBean) {
        if (homePageHeadBean.getMsg().equals(GetData.MSG_SUCCESS)) {
            Glide.with(this).load(homePageHeadBean.getData().getHeadImg()).into(homePage_Avatar);
            homePage_Name.setText(homePageHeadBean.getData().getName());
            if ("1".equals(homePageHeadBean.getData().getSex())) {
                homePage_Sex.setImageResource(R.mipmap.my_f);
            } else {
                homePage_Sex.setImageResource(R.mipmap.my_m);
            }
            my_Resume.setText(homePageHeadBean.getData().getIntroduction());
            homePage_works.setText(homePageHeadBean.getData().getWorks()+"");
            homePage_fans.setText(homePageHeadBean.getData().getFans()+"");
            homePage_attention.setText(homePageHeadBean.getData().getFollows()+"");
            homePage_theme.setText(homePageHeadBean.getData().getFollowSubject()+"");
        }else {
            Toast.makeText(this, "未获取到数据", Toast.LENGTH_SHORT).show();
        }
    }
}
