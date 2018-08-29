package com.zhenman.asus.zhenman.view.adapter.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import cn.youngkaaa.yviewpager.YFragmentPagerAdapter;

public class HomeHotVpAdapter extends YFragmentPagerAdapter {
    private List<Fragment> fragments;

    public HomeHotVpAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.isEmpty() ? 0 : fragments.size();
    }
}
