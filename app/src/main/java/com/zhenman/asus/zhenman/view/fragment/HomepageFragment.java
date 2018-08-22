package com.zhenman.asus.zhenman.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.view.adapter.HomeVPAdapter;
import com.zhenman.asus.zhenman.view.home.AttentionFragment;
import com.zhenman.asus.zhenman.view.home.HotFragment;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;


public class HomepageFragment extends BaseFragment  {
    ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPager HomePage_Viewpager;
    private AttentionFragment attentionFragment;
    private HotFragment hotFragment;
    private AutoRelativeLayout homePage_headView;
    private TextView homePage_attentionText;
    private TextView homePage_hotText;
    private FragmentManager supportFragmentManager;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void init() {
        //主页Viewpager
        HomePage_Viewpager = getActivity().findViewById(R.id.HomePage_Viewpager);
        //关注fragment
        attentionFragment = new AttentionFragment();
        //热门Fragment
        hotFragment = new HotFragment();
        //添加到集合
        fragments.add(hotFragment);
        fragments.add(attentionFragment);
        //得到FragmentMessage
        supportFragmentManager = getActivity().getSupportFragmentManager();
        //设置适配器
        HomePage_Viewpager.setAdapter(new HomeVPAdapter(supportFragmentManager,fragments));
    }

    @Override
    protected void loadDate() {

    }


}
