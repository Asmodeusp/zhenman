package com.zhenman.asus.zhenman.view.adapter.home;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


public class


HomeVPAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> Titles;

    public HomeVPAdapter(FragmentManager fm, List<Fragment> fragments, List<String> Titles) {
        super(fm);
        this.fragments = fragments;
        this.Titles = Titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.isEmpty() ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles.get(position);
    }
}