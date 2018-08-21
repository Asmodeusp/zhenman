package com.zhenman.asus.zhenman.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;
import com.zhenman.asus.zhenman.view.home.HotFragment;
import com.zhenman.asus.zhenman.view.home.AttentionFragment;

import java.util.ArrayList;


public class HomepageFragment extends BaseFragment {
    ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPager HomePage_Viewpager;
    private AttentionFragment attentionFragment;
    private HotFragment hotFragment;
    ArrayList<String> titles = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void init() {
        HomePage_Viewpager = getActivity().findViewById(R.id.HomePage_Viewpager);
        attentionFragment = new AttentionFragment();
        hotFragment = new HotFragment();
        fragments.add(hotFragment);
        fragments.add(attentionFragment);
        titles.add("热门");
        titles.add("关注");

    }

    @Override
    protected void loadDate() {

    }

}
