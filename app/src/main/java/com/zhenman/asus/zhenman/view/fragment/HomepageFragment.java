package com.zhenman.asus.zhenman.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.view.ContentActivity;
import com.zhenman.asus.zhenman.view.adapter.home.HomeVPAdapter;
import com.zhenman.asus.zhenman.view.home.AttentionFragment;
import com.zhenman.asus.zhenman.view.home.HotFragment;
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
        //TabLayout
        home_tablayout = getActivity().findViewById(R.id.Home_Tablayout);

        //关注fragment
        attentionFragment = new AttentionFragment(home_headView);
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


    }

    @Override
    protected void loadDate() {

    }


}
