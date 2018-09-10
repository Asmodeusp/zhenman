package com.zhenman.asus.zhenman.view.adapter.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;



public class HomeHotVerticalVpAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments ;
    public HomeHotVerticalVpAdapter( ArrayList<Fragment> fragments,FragmentManager fm) {
        super(fm);
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
