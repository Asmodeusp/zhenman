package com.zhenman.asus.zhenman.view.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.view.ContentActivity;
import com.zhenman.asus.zhenman.view.adapter.home.HomeVPAdapter;
import com.zhenman.asus.zhenman.view.home.AttentionFragment;
import com.zhenman.asus.zhenman.view.home.HotFragment;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyLikeFragment;
import com.zhenman.asus.zhenman.view.myself.fragment.HomePageMyWorkFragment;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;


public class HomepageFragment extends BaseFragment {
    ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPager HomePage_Pager;
    private AttentionFragment attentionFragment;
    private HotFragment hotFragment;
    private FragmentManager supportFragmentManager;
    ArrayList<String> Titles = new ArrayList<>();
    private AutoRelativeLayout home_headView;
    private ImageView homeHot_search_img;
    private TabLayout home_tablayout;
    public AutoLinearLayout group;
    private TextView homeText;
    private TextView messageText;
    private TextView myselfText;
    private TextView serializationText;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void init() {
        //主页Viewpager
        HomePage_Pager = getActivity().findViewById(R.id.HomePage_Pager);
        //HeadView头布局
        home_headView = getActivity().findViewById(R.id.Home_HeadView);
        //搜索
        homeHot_search_img = getActivity().findViewById(R.id.HomeHot_search_Img);
        homeHot_search_img.setVisibility(View.GONE);
        //TabLayout
        home_tablayout = getActivity().findViewById(R.id.Home_Tablayout);
        //关注fragment
        attentionFragment = new AttentionFragment();
        //热门Fragment
        hotFragment = new HotFragment(home_headView);
        //添加Title
        Titles.add("热门");
        Titles.add("关注");
        //添加到Fragment
        fragments.add(hotFragment);
        fragments.add(attentionFragment);
        //得到FragmentMessage
        supportFragmentManager = getActivity().getSupportFragmentManager();
        //设置适配器
        HomeVPAdapter homeVPAdapter = new HomeVPAdapter(supportFragmentManager, fragments, Titles);
        HomePage_Pager.setAdapter(homeVPAdapter);
        home_tablayout.setupWithViewPager(HomePage_Pager);
        //设置分割线
        LinearLayout linearLayout = (LinearLayout) home_tablayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getContext(),
                R.drawable.layout_divider_vertical));
        linearLayout.setDividerPadding(24);
        home_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        setTextColor("#ffffff");
                        break;
                    case 1:
                        setTextColor("#000000");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void loadDate() {
        homeText = ((ContentActivity) getActivity()).getHomeText();
        messageText = ((ContentActivity) getActivity()).getMessageText();
        myselfText = ((ContentActivity) getActivity()).getMyselfText();
        serializationText = ((ContentActivity) getActivity()).getSerializationText();
    }

    //设置字体颜色
    private void setTextColor(String color) {

        homeText.setTextColor(Color.parseColor(color));
        serializationText.setTextColor(Color.parseColor(color));
        messageText.setTextColor(Color.parseColor(color));
        myselfText.setTextColor(Color.parseColor(color));

    }

}
